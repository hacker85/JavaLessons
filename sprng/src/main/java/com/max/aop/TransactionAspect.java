package com.max.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 1)
public class TransactionAspect { //} implements Ordered {

//    @Pointcut("execution(* com.max.aop.UserRepository.printName(String)) && args(name)")
//    public void printName(String name) {}
//
//    @Before("printName(name)")
    public void printNameBefore(String name) {
        System.out.println("before print name " + name);
    }

    @Pointcut("execution(* com.max.aop.Repo.getInfo())")
//    @Pointcut("execution(public * com.max.aop.Repo.getInfo())")
//    @Pointcut("execution(public void com.max.aop.Repo.getInfo())")
//    @Pointcut("execution(public void com.max.aop.Repo.*())")
//    @Pointcut("execution(public void com.max.aop.Repo.*(..))")
//    @Pointcut("execution(public void com.max.aop..*(..))")
//    @Pointcut("execution(public void com.max.aop.*.*(..))")
//    @Pointcut("execution(public void com.max.aop..*(..)) && execution(* com.max.aop.*.*()))")
//    @Pointcut("execution(public void com.max.aop..*(..)) || execution(* com.max.aop.*.*()))")
//    @Pointcut("execution(public void com.max.aop..*(..)) ! execution(* com.max.aop.*.*()))")
//    @Pointcut("execution(public void com.max.aop..*(..)) && within(com.max.aop.UserRepository)")
//    @Pointcut("within(com.max.aop.UserRepository)")
//    @Pointcut("within(com.max.aop.User*)")
//    @Pointcut("within(com.max.a*.User*)")
//    @Pointcut("execution(public * *(..))")
//    @Pointcut("bean(userRepo)")
//    @Pointcut("this(com.max.aop.Repo)")
//    @Pointcut("target(com.max.aop.Repo)")
//    @Pointcut("@target(org.springframework.stereotype.Component)")
//    @Pointcut("@annotation(org.springframework.context.annotation.Primary)")
    public void getInfo() {}

//    @Before("execution(* com.max.aop.Repo.getInfo())")
    @Before("getInfo()")
    private void before() {
        System.out.println("transaction begin");
    }

    @After("getInfo()")
//    @After("execution(* com.max.aop.Repo.getInfo())")
    private void after() {
        System.out.println("transaction returned");
    }

    @AfterReturning("getInfo()")
//    @AfterReturning("execution(* com.max.aop.Repo.getInfo())")
    private void afterReturn() {
        System.out.println("transaction commit");
    }

    @AfterThrowing("getInfo()")
//    @AfterThrowing("execution(* com.max.aop.Repo.getInfo())")
    private void afterThrowing() {
        System.out.println("transaction rollback");
    }

//    public int getOrder() {
//        return 0;
//    }
}
