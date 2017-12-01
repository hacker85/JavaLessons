package com.max.test.impl;

import com.max.test.interfaces.Car;
import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive");
    }
}
