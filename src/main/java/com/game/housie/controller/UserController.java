package com.game.housie.controller;
import com.game.housie.dao.RoleRepository;
import com.game.housie.entity.Role;
import com.game.housie.entity.User;
import com.game.housie.service.SecurityService;
import com.game.housie.service.UserService;
import com.game.housie.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    RoleRepository roleRepository;

    /*@ModelAttribute("roleList")
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }*/


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User u =new User();
       // u.setRoles(rolelist);
        model.addAttribute("userForm",u);
        model.addAttribute("roleList",roleRepository.findAll());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("roleList",roleRepository.findAll());
            return "registration";
        }

            userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
 
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcomePage(HttpServletRequest request,Model model) {
    		return "welcome";	
    }
    
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "admin";
    }
}