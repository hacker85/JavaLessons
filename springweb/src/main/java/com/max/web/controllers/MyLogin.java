package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyLogin {
    @GetMapping("mylogin")
    public String MyLogin() {
        return "mylogin";
    }
}
