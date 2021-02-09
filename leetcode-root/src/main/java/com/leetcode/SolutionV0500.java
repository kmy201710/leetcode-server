package com.leetcode;

import com.leetcode.model.Keyboard;
import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import com.sun.deploy.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 500. 键盘行（简单）
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0500 {
    private static Logger logger = Logger.getLogger(SolutionV0500.class);

    private static List<String> list = new ArrayList<>();

    public SolutionV0500(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = RandomUtils.randomCommon(MockUtils.str, n);
        }
        logger.info("words = " + Arrays.toString(words));

        findWords(words);
        logger.info("findWords = " + StringUtils.join(list, " "));
        logger.info("=====end=====");
    }

    public void findWords(String[] words) { // public String[] findWords(String[] words) {
        int res;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            res = helper(word, 0, 0);
            logger.info("helper = " + res);
        }
    }

    private int helper(String word, int index, int res) {
        if (word.length() == index) {
            list.add(word);
            return res;
        }
        char c = word.charAt(index);
        if (index == 0 || res == 0) {
            if(check(Keyboard.set1, c)) {
                res = 1;
            } else if(check(Keyboard.set2, c)) {
                res = 2;
            } else if(check(Keyboard.set3, c)) {
                res = 3;
            } else {
                return res;
            }
        } else if (res == 1 && !check(Keyboard.set1, c)) {
            return 0;
        } else if (res == 2 && !check(Keyboard.set2, c)) {
            return 0;
        } else if (res == 3 && !check(Keyboard.set3, c)) {
            return 0;
        }
        index++;
        return helper(word, index, res);
    }

    private boolean check(char[] set, char c) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] == c) {
                return true;
            }
        }
        return false;
    }
}
