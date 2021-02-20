package com.leetcode.utils;

import java.util.Scanner;

/**
 * @Author hhe
 * @Date 2021/2/4 13:51
 * @Description
 */
public class MockUtils {
    public static String str = "t  1  23451the#ffddcadcad";

    /**
     * 模拟输入
     */
    public static int get(int max) {
        String mock = System.getProperty("mock");
        int num;
        if (mock == null || mock.equals("")) {
            // 接收从控制台输入
            Scanner input = new Scanner(System.in);
            num = input.nextInt();
        } else {
            num = Integer.valueOf(mock);
        }
        return num < 3 ? 3 : num % max;
    }
}
