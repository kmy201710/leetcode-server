package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 题库
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution344 {
    private static List<Character> list = new ArrayList();

    public void reverseString(String s) {
        helper(s.toCharArray(), 0);
    }

    private void helper(char[] c, int index) {
        if (c.length == index) {
            return;
        }
        helper(c, index + 1);
        list.add(c[index]);
    }

    public static void main(String[] args) {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        String s = RandomUtils.randomCommon("a2546fdmfdscx", n);
        System.out.println("s = " + s);

        new Solution344().reverseString(s);
        System.out.println("Solution344 = " + list.toString());
        System.out.println("=====end=====");
    }
}
