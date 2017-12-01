package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Part;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class FileController {
    @GetMapping("file")
    public String fileForm() {
        return "file";
    }

    @RequestMapping(value="/file", method=POST)
    @ResponseBody
//    public String processRegistration(@RequestPart("file") byte file) throws IOException {
//    public String processRegistration(@RequestPart("file") MultipartFile file) throws IOException {
    public String processRegistration(@RequestPart("file") Part file) throws IOException {
//        file.transferTo(new File(file.getOriginalFilename()));
        file.write(file.getSubmittedFileName());
        return "hello";
    }
}
