package com.leetcode.spi.service;

import com.leetcode.spi.HelloService;

public class AServiceImpl implements HelloService {

    @Override
    public String say(String userName) {
        return "A say: " + userName;
    }
}
