package com.max.web;

import com.max.web.repo.User;
import org.springframework.stereotype.Component;

@Component
public class WebFlowActions {
    boolean b = true;
    public void printHello() {
        System.out.println("hello world");
    }
    public void printI(int i) {
        System.out.println(i);
    }
    public boolean isAvailable() {
        b = !b;
        return b;
    }
    public int getI() {
        return 4;
    }
    public void printUser(User user) {
        System.out.println(user.getName());
    }
    public void printEnd() {
        System.out.println("end");
    }
}
