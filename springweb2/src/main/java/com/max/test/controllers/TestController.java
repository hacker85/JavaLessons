package com.max.test.controllers;

import com.max.test.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        return "test!!!";
    }
    @PostMapping(value = "testPost")
    public User testPost() {
        return new User("Max");
    }
//    @GetMapping("testParams/{id}")
//    public String testParams(@PathVariable int id) {
    @GetMapping("testParams")
    public String testParams(@RequestParam int id) {
        return "" + id;
    }
}
