package com.max.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class UserRepoIntroducer {
    @DeclareParents(value = "com.max.aop.Repo+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
