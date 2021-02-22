package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/22 10:00
 * @Description LCP 02. 分式化简（简单）
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionLCP02 {
    private static Logger logger = Logger.getLogger(SolutionLCP02.class);

    public SolutionLCP02(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        logger.info("=====end=====");
    }
}
