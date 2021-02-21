package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/21 10:24
 * @Description 697. 数组的度（简单）
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0697 {
    private static Logger logger = Logger.getLogger(SolutionV0697.class);

    public SolutionV0697(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        logger.info("=====end=====");
    }
}
