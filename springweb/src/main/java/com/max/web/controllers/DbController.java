package com.max.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DbController {
//    @Autowired
//    JdbcOperations jdbcOperations;

    @GetMapping("createTable")
    @ResponseBody
    public String createTeble() {
//        jdbcOperations.execute("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
        return "table was created";
    }
}
