package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description LCP 01. 猜数字（简单）
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionLCP01 {
    private static Logger logger = Logger.getLogger(SolutionLCP01.class);

    public SolutionLCP01(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums1 = RandomUtils.randomCommon(n);
        int[] nums2 = RandomUtils.randomCommon(n);
        logger.info("nums1 = " + Arrays.toString(nums1));
        logger.info("nums2 = " + Arrays.toString(nums2));

        int result = game(nums1, nums2);
        logger.info("game = " + result);
        logger.info("=====end=====");
    }

    public int game(int[] guess, int[] answer) {
        return helper(guess, answer, 0, 0);
    }

    private int helper(int[] guess, int[] answer, int index, int res) {
        if (guess.length == index) {
            return res;
        }
        if (guess[index] == answer[index]) {
            res++;
        }
        index++;
        return helper(guess, answer, index, res);
    }
}
