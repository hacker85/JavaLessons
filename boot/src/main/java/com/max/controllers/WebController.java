package com.max.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("webBoot")
    public String webBoot() {
        return "Hello world";
    }
}
