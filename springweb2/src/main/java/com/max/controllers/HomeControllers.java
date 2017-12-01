package com.max.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllers {
    @GetMapping("home")
    public String home() {
        return "home";
    }
}
