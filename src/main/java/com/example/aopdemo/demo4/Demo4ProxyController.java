package com.example.aopdemo.demo4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo4ProxyController {

    private final Demo4Controller demo4Controller;

    public Demo4ProxyController() {
        this.demo4Controller = (Demo4Controller) new Demo4ProxyFactory(new Demo4Controller()).getProxy();
    }

    @GetMapping("/hello4/{name}")
    public String hello(@PathVariable("name") String name) {
        return demo4Controller.hello(name);
    }

    @GetMapping("/hello4/sub/{name}")
    public String helloSub(@PathVariable("name") String name) {
        return demo4Controller.helloSub(name);
    }
}

