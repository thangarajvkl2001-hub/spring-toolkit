package org.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* org.example.aop.service.*.*(..))")
    public void verifyUser(){
        String user = "ADMIN";

        if (!"ADMIN".equals(user)){
            throw new RuntimeException("unauthorized access");
        }

        System.out.println("security validation passed");
    }
}
