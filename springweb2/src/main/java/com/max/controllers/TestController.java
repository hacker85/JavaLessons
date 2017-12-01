package com.max.controllers;

import com.max.interfaces.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    Repo repo;
    @GetMapping("test")
    public String test() throws IOException {
//        repo.createTable();
        return "test";
    }
}
