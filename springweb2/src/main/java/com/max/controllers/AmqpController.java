package com.max.controllers;

import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class AmqpController {
    @Autowired
    RabbitOperations rabbitOperations;
    @GetMapping("sendAmqpMessage")
    public String sendMessage() {
        rabbitOperations.convertAndSend("myqueue", "Hello, world!");
        return "message was sent";
    }
    @GetMapping("readAmqpMessage")
    public String readMessage() {
        return rabbitOperations.receiveAndConvert("myqueue").toString();
    }
}
