package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 231. 2的幂（简单）
 * 给定一个整数，写一个函数来判断它是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 2 的幂次方需满足：存在整数 x 使得 n == 2x
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0231 {
    private static Logger logger = Logger.getLogger(SolutionV0231.class);

    public SolutionV0231(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        boolean result = isPowerOfTwo(num);
        logger.info("isPowerOfTwo = " + result);
        logger.info("=====end=====");
    }

    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
}
