package com.leetcode.utils;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * 随机数工具类  https://blog.csdn.net/sinat_32829963/article/details/70232076
 *
 * @author hhe
 * @date 2021/2/3 17:35
 * @Description
 */
public class RandomUtils {

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    public static int[] randomCommon(int n) {
        return randomCommon(0, 10, n);
    }

    public static String randomCommon(String str, int n) {
        char[] c = str.toCharArray();
        int[] nums = randomCommon(n);
        String result = "";
        List<String> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            result += String.valueOf(c[nums[i]]);
        }
        return result;
    }

    public static int[] randomCommon2(int n) {
        int[] nums = helper(n);
        return SortUtils.selectionSort(nums);
    }

    public static int[] helper(int n) {
        int[] nums = randomCommon(0, 10, n);
        if (nums[0] < 5) {
            nums = helper(n);
            return nums;
        }
        return nums;
    }
}