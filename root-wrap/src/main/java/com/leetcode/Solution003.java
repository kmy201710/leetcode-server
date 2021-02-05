package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;

import java.util.*;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution003 {

    public int lengthOfLongestSubstring(char[] c) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                return i + 1;
            }
            map.put(c[i], i);
        }
        return -1;
    }

    public static void main(String[] args) {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        String s = RandomUtils.randomCommon("a2546123fda2dsfdmfdscx", n);
        System.out.println("s = " + s);

        int length = new Solution003().lengthOfLongestSubstring(s.toCharArray());
        System.out.println("Solution003 = " + length);
        System.out.println("=====end=====");
    }
}
