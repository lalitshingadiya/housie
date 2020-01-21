package com.game.housie.controller;

import com.game.housie.dto.EventDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class adminController {

        @GetMapping("/eventPage")
        public ModelAndView getEventPage(){
            ModelAndView model = new ModelAndView();
            model.addObject("event",new EventDTO());
            model.setViewName("eventMaster");
            return model;
        }

    @GetMapping("/pricePage")
    public String getPricePage(){
        return "priceMaster";
    }
}
