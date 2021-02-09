package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 342. 4的幂（简单）
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0342 {
    private static Logger logger = Logger.getLogger(SolutionV0342.class);

    public SolutionV0342(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(Integer.MAX_VALUE, n);
        logger.info("num = " + num);

        boolean result = isPowerOfFour(num);
        logger.info("isPowerOfFour = " + result);
        logger.info("=====end=====");
    }

    public boolean isPowerOfFour(int n) {
        return (n & (n-1)) == 0 && (n & 0x55555555) == n;
    }
}
