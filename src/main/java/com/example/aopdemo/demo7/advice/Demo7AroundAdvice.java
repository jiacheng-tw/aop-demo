package com.example.aopdemo.demo7.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class Demo7AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Around => request with args : {}", invocation.getArguments());
        Object response = invocation.proceed();
        log.info("Around => response msg : {}", response);

        return response;
    }
}
