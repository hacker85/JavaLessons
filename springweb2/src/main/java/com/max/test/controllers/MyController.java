package com.max.test.controllers;

import com.max.test.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("myTest")
    public String test() {
        return "test!!!";
    }
    @PostMapping("testJson")
    public User json() {
        return new User("Max");
    }
    @PutMapping("testParam")
    public String testParams(@RequestParam int id) {
//    @PutMapping("testParam/{id}")
//    public String testParams(@PathVariable int id) {
        return "" + id;
    }
}
