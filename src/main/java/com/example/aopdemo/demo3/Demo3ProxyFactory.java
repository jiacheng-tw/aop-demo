package com.example.aopdemo.demo3;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class Demo3ProxyFactory {

    private final Object target;

    public Demo3ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new Demo3ProxyHandler());
    }
    
    private class Demo3ProxyHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("=> request with args: {}", args);
            Object response = method.invoke(target, args);
            log.info("=> response msg: {}", response);

            return response;
        }
    }
}
