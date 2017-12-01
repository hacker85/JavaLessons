package com.max;

import org.springframework.stereotype.Component;

@Component
public class MyMBean {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName() throws InterruptedException {
        System.out.println(name);
    }
}
