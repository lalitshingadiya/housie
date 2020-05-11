package com.game.housie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)//400
    public ModelAndView getIllegalArgument(HttpServletRequest request, HttpServletResponse response, Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("exception",e.getMessage());
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("errorPage");
        return mv;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)//404
    public ModelAndView getErrorPage(HttpServletRequest request, HttpServletResponse response, Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("exception",e.getMessage());
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("errorPage");
        return mv;

    }
}
