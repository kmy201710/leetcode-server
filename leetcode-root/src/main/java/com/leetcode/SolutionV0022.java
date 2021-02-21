package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/21 10:24
 * @Description 22. 括号生成（中等）
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0022 {
    private static Logger logger = Logger.getLogger(SolutionV0022.class);

    public SolutionV0022(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        logger.info("=====end=====");
    }
}
