package com.leetcode.utils;

import java.util.Scanner;

/**
 *
 * @Author hhe
 * @Date 2021/2/4 13:51
 * @Description
 */
public class MockUtils {

    /**
     * 模拟输入
     */
    public static int get(int tag) {
        String mock = System.getProperty("mock");
        int n;
        if (mock == null || mock.equals("")) {
            // 接收从控制台输入
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
        } else {
            n = Integer.valueOf(mock);
        }
        return n < 5 ? 5 : n % tag;
    }

}
