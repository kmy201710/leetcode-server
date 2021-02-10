package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 202. 快乐数（简单）
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0202 {
    private static Logger logger = Logger.getLogger(SolutionV0202.class);

    public SolutionV0202(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(max, n);
        logger.info("num = " + num);

        boolean result = isHappy(num);
        logger.info("isHappy = " + result);
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = bitSquareSum(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = bitSquareSum(slowRunner);
            fastRunner = bitSquareSum(bitSquareSum(fastRunner));
        }
        return fastRunner == 1;
    }

    public int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}
