package com.example.aopdemo.demo6;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Demo6Advice {

    @Pointcut(value = "@annotation(Demo6Log)")
    public void demo6Pointcut() {}

    @Before("demo6Pointcut()")
    public void doLogBefore(JoinPoint joinPoint) {
        log.info("Before => request with args: {}", joinPoint.getArgs());
    }

    @After("demo6Pointcut() && @annotation(demo6Log)")
    public void doLogAfter(Demo6Log demo6Log) {
        log.info("After => request with value: {}", demo6Log.value());
    }

    @AfterReturning(pointcut = "demo6Pointcut()", returning = "response")
    public void doLogAfterReturning(String response) {
        log.info("AfterReturning => response msg: {}", response);
    }

    @Around("demo6Pointcut()")
    public Object doLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around => request with args : {}", joinPoint.getArgs());
        Object response = joinPoint.proceed();
        log.info("Around => response msg : {}", response);

        return response;
    }
}
