package com.max.web.controllers;

import com.max.web.repo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringLibController {
    @GetMapping("/springLib")
    public String getParams(Model model) {
        model.addAttribute("user", new User());
        return "springLib";
    }
}
