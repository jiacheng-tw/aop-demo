package com.example.aopdemo.demo3;

public class Demo3Controller implements Demo3{

    @Override
    public String hello(String name) {
        return "3 - Hello, " + name;
    }

    public String helloSub(String name) {
        return "3 - Hello, " + name;
    }
}
