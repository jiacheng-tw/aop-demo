package com.example.aopdemo.demo6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo6Controller {

    @GetMapping("/hello6")
    public String hello() {
        return "6 - Hello, Demo6";
    }

    @Demo6Log("demo-6")
    @GetMapping("/hello6/{name}")
    public String hello(@PathVariable("name") String name) {
        return "6 - Hello, " + name;
    }
}
