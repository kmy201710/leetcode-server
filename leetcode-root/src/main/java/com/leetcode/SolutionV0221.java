package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/21 10:24
 * @Description 221. 最大正方形（中等）
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0221 {
    private static Logger logger = Logger.getLogger(SolutionV0221.class);

    public SolutionV0221(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        logger.info("=====end=====");
    }
}
