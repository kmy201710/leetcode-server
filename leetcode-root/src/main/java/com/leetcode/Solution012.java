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
 * @Description 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution012 {
    private static Logger logger = Logger.getLogger(Solution012.class);

    private static ListNode node = ListNode.get(new Roman());

    public Solution012() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        String result = intToRoman(nums);
        logger.info("intToRoman = " + result);
        logger.info("=====end=====");
    }

    public String intToRoman(int[] nums) {
        String s = "";
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        return helper(Integer.valueOf(s), "");
    }

    private String helper(int num, String val) {
        if (num == 0) {
            return val;
        }
        int n = num / node.val;
        int carry = num % node.val;
        for (int i = 0; i < n; i++) {
            val += node.name;
        }
        node = node.next;
        return helper(carry, val);
    }
}
