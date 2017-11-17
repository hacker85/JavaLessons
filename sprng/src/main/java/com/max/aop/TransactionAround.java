package com.max.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class TransactionAround {
//    @Around("execution(* com.max.aop.Repo.getInfo())")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("transaction begin");
            jp.proceed();
            System.out.println("transaction end");
        } catch (Throwable e) {
            System.out.println("transaction rollback");
        } finally {
            System.out.println("transaction commit");
        }
    }
}
