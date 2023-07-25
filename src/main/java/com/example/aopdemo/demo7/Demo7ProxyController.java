package com.example.aopdemo.demo7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo7ProxyController {

    private final Demo7Controller demo7Controller;

    public Demo7ProxyController() {
        this.demo7Controller = (Demo7Controller) Demo7ProxyFactory.getProxy(new Demo7Controller());
    }

    @GetMapping("/hello7/{name}")
    public final String hello(@PathVariable("name") String name) {
        return demo7Controller.hello(name);
    }

    @GetMapping("/hello7/sub/{name}")
    public final String helloSub(@PathVariable("name") String name) {
        return demo7Controller.helloSub(name);
    }
}
