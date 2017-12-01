package com.max.web.controllers;

import com.max.web.repo.User;
import com.max.web.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("home")
public class HelloWorldController {
    @Autowired
    UserRepo userRepository;
//    @RequestMapping(value= {"hello", "world"}, method = RequestMethod.GET, params = "!myParam")
//    @GetMapping(value = "hello")
    @GetMapping(value = "home")
//    public User home(Model model) {
//    public User home(Map model) {
    public User home() {
//        model.addAttribute("Max");
//        model.addAttribute("name", "Mike");
//        model.addAttribute(userRepository.getUser());
//        model.put("name", "Max");
//        return "home";
        return userRepository.getUser();
    }
}
