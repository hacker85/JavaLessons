package com.max.test;

import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car {
    public void drive() {
        System.out.println("drive");
    }
}
