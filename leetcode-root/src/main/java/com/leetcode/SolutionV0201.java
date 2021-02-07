package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 201. 数字范围按位与（中等）
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0201 {
    private static Logger logger = Logger.getLogger(SolutionV0201.class);

    public SolutionV0201() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));
    }

    public int rangeBitwiseAnd(int m, int n) {
        return 0;
    }
}
