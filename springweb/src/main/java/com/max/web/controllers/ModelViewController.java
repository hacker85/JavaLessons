package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelViewController {
    @GetMapping("modelView")
    public ModelAndView getMethod() {
        ModelAndView modelAndView = new ModelAndView("modelView");
        modelAndView.addObject("userName", "Max");
        return modelAndView;
    }
}
