package com.example.aopdemo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Demo2ProxyController implements Demo2{

    private final Demo2Controller demo2Controller;

    public Demo2ProxyController(Demo2Controller demo2Controller) {
        this.demo2Controller = demo2Controller;
    }

    @Override
    @GetMapping("hello2/{name}")
    public String hello(@PathVariable("name") String name) {
        log.info("=> request with name: {}", name);
        String response = demo2Controller.hello(name);
        log.info("=> response msg: {}", response);

        return response;
    }
}
