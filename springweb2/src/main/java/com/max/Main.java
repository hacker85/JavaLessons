package com.max;

import com.max.entities.User;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();
        User user = rest.getForObject("http://localhost:8080/userest", User.class);
        System.out.println(user.getName());
//        ApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
//        SoapService bean = context.getBean(SoapService.class);
//        bean.printMessage("Hello world");
    }
}
