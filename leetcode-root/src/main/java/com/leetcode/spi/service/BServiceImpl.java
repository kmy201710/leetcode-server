package com.leetcode.spi.service;

import com.leetcode.spi.HelloService;

public class BServiceImpl implements HelloService {

    @Override
    public String say(String userName) {
        return "B say: " + userName;
    }
}
