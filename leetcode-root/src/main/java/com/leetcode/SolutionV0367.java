package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/10 10:24
 * @Description 367. 有效的完全平方数（简单）
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0367 {
    private static Logger logger = Logger.getLogger(SolutionV0367.class);

    public SolutionV0367(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        boolean result = isPerfectSquare(num);
        logger.info("isPerfectSquare = " + result);
        logger.info("=====end=====");
    }

    /**
     * 1 4=1+3 9=1+3+5 16=1+3+5+7以此类推，模仿它可以使用一个while循环，不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是。
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        return helper(num, 1);
    }

    private boolean helper(int num, int n) {
        if (num == n) {
            return true;
        } else if (num < n) {
            return false;
        }
        num -= n;
        n += 2;
        return helper(num, n);
    }
}
