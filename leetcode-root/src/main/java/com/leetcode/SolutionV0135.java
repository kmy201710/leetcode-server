package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 135. 分发糖果（困难）
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0135 {
    private static Logger logger = Logger.getLogger(SolutionV0135.class);

    public SolutionV0135(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        int result = candy(nums);
        logger.info("candy = " + result);
        logger.info("=====end=====");
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        return helper(ratings, left, n-1, 0, 0);
    }

    private int helper(int[] ratings, int[] left, int index, int pre, int res) {
        if (index == 0) {
            return res;
        }
        if (index < ratings.length - 1 && ratings[index] > ratings[index + 1]) {
            pre++;
        } else {
            pre = 1;
        }
        res += Math.max(left[index], pre);
        index--;
        return helper(ratings, left, index, pre, res);
    }
}
