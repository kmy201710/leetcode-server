package com.leetcode;

import com.leetcode.utils.MockUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/10 10:24
 * @Description 368. 最大整除子集（中等）
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * 如果有多个目标子集，返回其中任何一个均可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0368 {
    private static Logger logger = Logger.getLogger(SolutionV0368.class);

    public SolutionV0368(int max) {
        // 模拟输入
        int n = MockUtils.get(max);

        logger.info("largestDivisibleSubset = ");
        logger.info("=====end=====");
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        return null;
    }

}
