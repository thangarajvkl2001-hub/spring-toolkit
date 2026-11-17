package org.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.example.aop.service.*.*(..))") //pointcut expression to match all methods in the service package
    public void serviceMethods() {
    }

    @Before("serviceMethods()") //advice to be executed before the matched methods
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("serviceMethods()") //advice to be executed after the matched methods
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Method executed: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        System.out.println("Exception occured " + ex.getMessage());
    }
}