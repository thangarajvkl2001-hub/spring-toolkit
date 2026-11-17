package org.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("@annotation(org.example.aop.configuration.TrackExecution)")
    public Object monitorExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Execution started: "+ joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end-start) + " ms");
        return result;
    }
}
