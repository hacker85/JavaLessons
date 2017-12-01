package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiberController {
//    @Autowired
//    UserAutoRepository userAutoRepository;
//    MyRepo myRepo;
    @GetMapping("hiber")
    @ResponseBody
    public String saveUser() {
//        userAutoRepository.findAll();
//        myRepo.saveUser(new User("Max"));
        return "user was saved";
    }
}
