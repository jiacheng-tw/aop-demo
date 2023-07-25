package com.example.aopdemo.demo2;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class Demo2Controller implements Demo2{

    @Override
    public String hello(@PathVariable("name") String name) {
        return "2 - Hello, " + name;
    }
}
