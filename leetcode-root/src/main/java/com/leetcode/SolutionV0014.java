package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 14. 最长公共前缀（简单）
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0014 {
    private static Logger logger = Logger.getLogger(SolutionV0014.class);

    public SolutionV0014() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = "leet" + RandomUtils.randomCommon(MockUtils.str, nums[i]);
        }
        logger.info("strs = " + Arrays.toString(strs));

        String result = longestCommonPrefix(strs);
        logger.info("longestCommonPrefix = " + result);
        logger.info("=====end=====");
    }

    public String longestCommonPrefix(String[] strs) {
        return helper(strs, 0, strs.length - 1);
    }

    private String helper(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftStr = helper(strs, left, mid);
        String rightStr = helper(strs, mid + 1, right);
        return commonPrefix(leftStr, rightStr);
    }

    private String commonPrefix(String leftStr, String rightStr) {
        int minLength = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < minLength; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                minLength = i;
                break;
            }
        }
        return leftStr.substring(0, minLength);
    }
}
