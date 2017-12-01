package com.max.web.controllers;

import com.max.web.repo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("vars/{userId}")
public class ParametersController {
    @GetMapping("param")
    @ResponseBody
    public String getParams(@RequestParam(value = "one", defaultValue = "five") String one,
                            @RequestParam int three) {
        return "hello world " + one + " " + three;
    }

//    @GetMapping("{id}")
    @GetMapping("vars/{userId}/{userName}")
//    @GetMapping("vars/{name:[a-z-]+}")
    @ResponseBody
    public String getVars(@PathVariable("userId") Long userId, @PathVariable("userName") String userName) {
        return "hello world " + userId + " " + userName;
    }

//    @GetMapping("/matrix/")
//    @ResponseBody
////    public String getMatrix(@MatrixVariable("name") String name, @MatrixVariable("age") int age) {
//    public String getMatrix(@MatrixVariable String q) {
//        return "hello world " + q;// + " " + age;
//    }

    @GetMapping("form")
    public String getForm() {
        return "myForm";
    }

    @PostMapping("form")
//    @ResponseBody
//    public String postForm(@RequestParam String name, @RequestParam int age) {
//    public String postForm(User user) {
    public String postForm(User user, RedirectAttributes model) {
//    public String postForm(User user, HttpSession session) {
//        return name + " " + age;
//        return user.getName() + " " + user.getAge();
        model.addFlashAttribute("user", user);
//        session.setAttribute("user", user);
        return "redirect:/spring/redirTo";
//        return "forward:/spring/redirTo";
    }

//    @PostMapping("json")
//    @JsonView(User.class)
//    public String jsonExmple(User user) {
////        return name + " " + age;
//        return user.getName() + " " + user.getAge();
//    }
}
