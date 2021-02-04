package com.leetcode;

import com.leetcode.spi.HelloService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author hhe
 * @Date  2021/2/4 19:13
 * @Description Spi测试类
 */
public class MySpi {

    public static void main(String[] args) {
        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            HelloService helloService = iterator.next();
            helloService.sayHello("host");
        }
        System.out.println("=====end=====");
    }

}
