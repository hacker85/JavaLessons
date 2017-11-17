package com.max.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
//        ProxyFactory factory = new ProxyFactory(new UserRepository());
//        factory.adddInterface(Repo.class);
//        factory.addAdvice(new RetryAdvice());
//        factory.setExposeProxy(true);
//        Repo repo = (Repo) factory.getProxy();
//        repo.printName("Max");

        ApplicationContext context = new AnnotationConfigApplicationContext(com.max.aop.AspectConf.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:aspConf.xml");
        Repo bean = context.getBean(Repo.class);
//        bean.getInfo();
        bean.printName("Max");
//        Encoreable bean2 = (Encoreable) bean;
//        bean2.performEncore();
    }
}
