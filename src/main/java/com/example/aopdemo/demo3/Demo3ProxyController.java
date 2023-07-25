package com.example.aopdemo.demo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo3ProxyController {

    private final Demo3 demo3Proxy;

    public Demo3ProxyController() {
        this.demo3Proxy = (Demo3) (new Demo3ProxyFactory(new Demo3Controller()).getProxy());
    }

    @GetMapping("/hello3/{name}")
    public String hello(@PathVariable("name") String name) {
        return demo3Proxy.hello(name);
    }

    @GetMapping("/hello3/sub/{name}")
    public String helloSub(@PathVariable("name") String name) {
        return ((Demo3Controller) demo3Proxy).helloSub(name);
    }
}
