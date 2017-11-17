package com.max.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 0)
public class TransactionAspect2 { //implements Ordered {
    @Before("execution(* com.max.aop.Repo.getInfo())")
    private void before() {
        System.out.println("transaction begin2");
    }

//    public int getOrder() {
//        return 1;
//    }
}
