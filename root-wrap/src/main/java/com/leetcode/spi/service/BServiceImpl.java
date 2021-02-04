package com.leetcode.spi.service;

import com.leetcode.spi.HelloService;

public class BServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        System.out.println("=====B=====");
        return "Hello: " + userName;
    }
}
