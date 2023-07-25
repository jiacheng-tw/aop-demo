package com.example.aopdemo.demo5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo5Controller {

    @GetMapping("/hello5/{name}")
    public String hello(@PathVariable("name") String name) {
        return "5 - Hello, " + name;
    }
}
