package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.model.Roman;
import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 12. 整数转罗马数字（中等）
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0012 {
    private static Logger logger = Logger.getLogger(SolutionV0012.class);

    private static ListNode node = Roman.get().node;

    public SolutionV0012(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        String result = intToRoman(nums);
        logger.info("intToRoman = " + result);
        logger.info("=====end=====");

        new SolutionV0013().romanToInt(result);
    }

    public String intToRoman(int[] nums) {
        String s = "";
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        return helper(Integer.valueOf(s), "");
    }

    private String helper(int num, String s) {
        if (num == 0) {
            return s;
        }
        int n = num / node.val;
        num = num % node.val;
        for (int i = 0; i < n; i++) {
            s += node.name;
        }
        node = node.next;
        return helper(num, s);
    }
}
