package com.max.web.controllers;

import com.max.web.repo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedirectController {
    @RequestMapping("myRedirect")
    public String redirectMe(@RequestParam String one) {
        return "redirect:/spring/redirectTo";
//        return "forward:/spring/redirectTo";
    }
    @RequestMapping("redirectTo")
    @ResponseBody
//    public String redirectTo(@RequestParam(required = false) String one) {
//    public String redirectTo(User user) {
//    public String redirectTo(Model model) {
    public String redirectTo(@SessionAttribute User user) {
        return "new page " + user.getName();
//        return "new page " + ((User)model.asMap().get("user")).getName();
    }
}
