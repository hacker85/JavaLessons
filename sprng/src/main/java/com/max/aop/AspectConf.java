package com.max.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan
public class AspectConf {
    @Bean
    TransactionAspect getTransaction() {
        return new TransactionAspect();
    }
//    @Bean
//    TransactionAspect2 getTransaction2() {
//        return new TransactionAspect2();
//    }
//    @Bean
//    TransactionAround getTransactionAround() {
//        return new TransactionAround();
//    }
//    @Bean
//    UserRepoIntroducer getIntroducer() {
//        return new UserRepoIntroducer();
//    }
}