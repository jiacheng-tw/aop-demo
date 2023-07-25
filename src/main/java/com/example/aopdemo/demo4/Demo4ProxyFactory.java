package com.example.aopdemo.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class Demo4ProxyFactory implements MethodInterceptor {

    private final Object target;

    public Demo4ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("=> request with args: {}", args);
        Object response = method.invoke(target, args);
        log.info("=> response msg: {}", response);

        return response;
    }
}
