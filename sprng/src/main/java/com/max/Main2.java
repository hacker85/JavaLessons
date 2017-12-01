package com.max;

import com.max.config.RmiConfig2;
import com.max.interfaces.RmiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RmiConfig2.class);
        RmiService bean = context.getBean(RmiService.class);
        bean.printMessage("hello world");
    }
}
