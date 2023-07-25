package com.example.aopdemo.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Demo1Controller {

    @GetMapping("hello1/{name}")
    public String hello(@PathVariable("name") String name) {
        log.info("=> request with name: {}", name);
        String response = "1 - Hello, " + name;
        log.info("=> response msg: {}", response);

        return response;
    }
}
