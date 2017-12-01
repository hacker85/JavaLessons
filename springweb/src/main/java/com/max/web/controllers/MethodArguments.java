package com.max.web.controllers;

import com.max.web.repo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Controller
//@SessionAttributes("user")
public class MethodArguments {
    @GetMapping("/args")
//    @ResponseBody
    public void getParams(Model model,
                          ServletRequest request,
                          ServletResponse response,
                          //Writer writer,
                          //OutputStream outputStream,
                          @CookieValue("JSESSIONID") String cookie,
                          @RequestHeader("Accept-Encoding") String encoding,
                          @SessionAttribute User user
    ) throws IOException {
//        writer.write("hello world");
//        response.getWriter().write("hello world");
        response.getWriter().write(cookie + " " + encoding + " " + user.getName());
//        return "hello world";
    }
}
