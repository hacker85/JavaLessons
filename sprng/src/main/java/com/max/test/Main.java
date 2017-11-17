package com.max.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.max.test.TestConfig.class);
        Car bean = context.getBean(Toyota.class);
        bean.drive();
    }
}
