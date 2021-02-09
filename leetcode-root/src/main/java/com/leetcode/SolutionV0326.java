package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 326. 3的幂（简单）
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0326 {
    private static Logger logger = Logger.getLogger(SolutionV0326.class);

    public SolutionV0326(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num = RandomUtils.randomCommon(Integer.MAX_VALUE, n);
        logger.info("num = " + num);

        boolean result = isPowerOfThree(num);
        logger.info("isPowerOfThree = " + result);
        logger.info("=====end=====");
    }

    /**
     * 我们可以看出 n 的类型是 int。在 Java 中说明了该变量是四个字节，他的最大值为 2147483647。有三种方法可以计算出该最大值。
     * 知道了 n 的限制，我们现在可以推断出 n 的最大值，也就是 3 的幂，是 1162261467。
     * 因此，我们应该返回 true 的 n 的可能值是 3^0,3^1,……,3^19。
     */
    public boolean isPowerOfThree(int n) {
        return 1162261467 % n == 0;
    }
}
