package com.max.web;

import com.max.web.repo.User;
import org.springframework.stereotype.Component;

@Component
public class MyFlowBean {
    public void printHello() {
        System.out.println("hello world");
    }
    public boolean trueOrFalse() {
        return false;
    }
    public void printUser(User user) {
        System.out.println(user.getName());
    }
    public void printI(int i) {
        System.out.println(i);
    }
}
