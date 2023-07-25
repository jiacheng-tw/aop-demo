package com.example.aopdemo.demo7;

import com.example.aopdemo.demo7.advice.Demo7AfterReturnAdvice;
import com.example.aopdemo.demo7.advice.Demo7AroundAdvice;
import com.example.aopdemo.demo7.advice.Demo7BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Demo7ProxyFactory {

    public static Object getProxy(Object target) {
        ProxyFactory proxyFactory = new ProxyFactory();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new Demo7Pointcut(), new Demo7AroundAdvice());
        proxyFactory.addAdvisor(advisor);
        proxyFactory.addAdvice(new Demo7BeforeAdvice());
        proxyFactory.addAdvice(new Demo7AfterReturnAdvice());
        proxyFactory.setTarget(target);

        return proxyFactory.getProxy();
    }
}
