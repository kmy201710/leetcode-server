package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/13 18:48
 * @Description 58. 最后一个单词的长度（简单）
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0058 {
    private static Logger logger = Logger.getLogger(SolutionV0058.class);

    public SolutionV0058(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        String s = RandomUtils.randomCommon(MockUtils.str, n);
        logger.info("s = |" + s + "|");

        int result = lengthOfLastWord(s);
        logger.info("lengthOfLastWord = " + result);
        logger.info("=====end=====");
    }

    public int lengthOfLastWord(String s) {
        int length = s.length() - 1;
        int end = length;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end == 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
