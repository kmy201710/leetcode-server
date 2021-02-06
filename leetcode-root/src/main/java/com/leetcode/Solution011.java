package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution011 {
    private static Logger logger = Logger.getLogger(Solution011.class);

    public Solution011() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        int result = maxArea(nums);
        logger.info("maxArea = " + result);
        logger.info("=====end=====");
    }

    public int maxArea(int[] height) {
        return helper(height, 0, height.length - 1, 0);
    }

    private int helper(int[] height, int left, int right, int maxArea) {
        if (left == right) {
            return maxArea;
        }
        int area;
        if (height[left] < height[right]) {
            area = height[left] * (right - left);
            left += 1;
        } else if (height[left] > height[right]) {
            area = height[right] * (right - left);
            right -= 1;
        } else {
            area = height[right] * (right - left);
            if (height[left + 1] > height[right - 1]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return helper(height, left, right, Math.max(area, maxArea));
    }
}
