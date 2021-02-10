package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 344. 反转字符串（简单）
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0344 {
    private static Logger logger = Logger.getLogger(SolutionV0344.class);

    private static List<Character> list = new ArrayList<>();

    public SolutionV0344(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        String s = RandomUtils.randomCommon(MockUtils.str, n);
        logger.info("s = " + s);

        reverseString(s);
        logger.info("reverseString = " + list.toString());
        logger.info("=====end=====");
    }

    public void reverseString(String s) { // public void reverseString(char[] s) {
        helper(s.toCharArray(), 0);
    }

    private void helper(char[] c, int index) {
        if (c.length == index) {
            return;
        }
        helper(c, index + 1);
        list.add(c[index]);
    }
}
