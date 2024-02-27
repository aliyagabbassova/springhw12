package com.example.spring_data_exam.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionAspect {
    @Pointcut("@annotation(TrackUserAction)")
    public void trackUserAction() {
    }

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
        System.out.println("Метод " + joinPoint.getSignature().getName() + " был вызван "
                + result.getClass());
    }


    @AfterThrowing(value = "@annotation(TrackUserAction)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Метод " + joinPoint.getSignature().getName() + " вернул исключение "
        + ex.getClass() + " " + ex.getMessage());
    }
}
