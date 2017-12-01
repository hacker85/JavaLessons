package com.max.controllers;

import com.max.entities.User;
import com.max.interfaces.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class JmsController {
    @Autowired
    JmsService jmsService;
    @GetMapping("sendMessage")
    public String sendMessage() {
        jmsService.sendMessage(new User("Max"));
        return "message was send";
    }
    @GetMapping("getMessage")
    public String getMessage() {
        User user = (User) jmsService.receiveMessage();
        return user.getName();
    }
}
