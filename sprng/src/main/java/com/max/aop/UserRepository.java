package com.max.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component("userRepo")
public class UserRepository implements Repo {
//    @Primary
    public void getInfo() {
        System.out.println("User max, age 22");
    }

    public void printName(String name) {
        ((Repo) AopContext.currentProxy()).getInfo();
        System.out.println(name);
    }
}
