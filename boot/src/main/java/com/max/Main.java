package com.max;

import com.max.interfaces.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(scanBasePackages = "com.max")
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan("com.max")
public class Main {
    @Autowired
    MyComponent myComponent;
    @Autowired
    ApplicationContext context;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            MyComponent bean1 = context.getBean(MyComponent.class);
            bean1.print();
            MyComponent bean = ctx.getBean(MyComponent.class);
            bean.print();
            myComponent.print();
        };
    }
}
