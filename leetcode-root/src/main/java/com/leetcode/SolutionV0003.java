package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 3. 无重复字符的最长子串（中等）
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0003 {
    private static Logger logger = Logger.getLogger(SolutionV0003.class);

    public SolutionV0003(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        String s = RandomUtils.randomCommon(MockUtils.str, n);
        logger.info("s = " + s);

        int result = lengthOfLongestSubstring(s);
        logger.info("lengthOfLongestSubstring = " + result);
        logger.info("=====end=====");
    }

    public int lengthOfLongestSubstring(String s) {
        return helper(s.toCharArray(), 0, 0);
    }

    private int helper(char[] c, int index, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = index; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                return helper(c, i, Math.max(i - index, length));
            }
            map.put(c[i], i);
        }
        return length;
    }
}
