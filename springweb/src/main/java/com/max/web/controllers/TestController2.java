package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController2 {
    @GetMapping("test2")
    @ResponseBody
    public String test() {
        return "test2";
    }
}