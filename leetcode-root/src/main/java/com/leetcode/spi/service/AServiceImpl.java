package com.leetcode.spi.service;

import com.leetcode.spi.HelloService;

public class AServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        System.out.println("=====A=====");
        return "Hello: " + userName;
    }
}
