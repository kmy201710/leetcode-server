package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 201. 数字范围按位与（中等）
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0201 {
    private static Logger logger = Logger.getLogger(SolutionV0201.class);

    public SolutionV0201(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int num1 = RandomUtils.randomCommon(max, n);
        int num2 = RandomUtils.randomCommon(max, n);
        logger.info("nums1 = " + num1);
        logger.info("nums2 = " + num2);

        int result = rangeBitwiseAnd(num1, num2);
        logger.info("rangeBitwiseAnd = " + result);
        logger.info("=====end=====");
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            return rangeBitwiseAnd(n, m);
        }
        List<Integer> list = new ArrayList<>();
        helper(m, n, 0, list);

        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            int shift = list.get(i);
            num += (1 << shift);
        }
        return num;
    }

    private List<Integer> helper(int m, int n, int shift, List<Integer> list) {
        if (m == 1) {
            if ((n & 1) == 1) {
                list.add(shift);
            }
            return list;
        }
        if ((m & 1) == 1 && (n & 1) == 1) {
            list.add(shift);
        }
        // 找到公共前缀
        m = m >> 1;
        n = n >> 1;
        shift++;
        return helper(m, n, shift, list);
    }
}
