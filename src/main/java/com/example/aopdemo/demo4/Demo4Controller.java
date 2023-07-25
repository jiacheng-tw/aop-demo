package com.example.aopdemo.demo4;

import com.example.aopdemo.demo3.Demo3;

public class Demo4Controller implements Demo3 {

    @Override
    public String hello(String name) {
        return "4 - Hello, " + name;
    }

    public final String helloSub(String name) {
        return "4 - Hello, " + name;
    }
}
