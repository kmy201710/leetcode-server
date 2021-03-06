package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/21 10:24
 * @Description 16. 最接近的三数之和（中等）
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0016 {
    private static Logger logger = Logger.getLogger(SolutionV0016.class);

    public SolutionV0016(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(-5, 10, n);
        logger.info("nums = " + Arrays.toString(nums));

        int result = threeSumClosest(nums, 5);
        logger.info("longestCommonPrefix = " + result);
        logger.info("=====end=====");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        logger.info("nums = " + Arrays.toString(nums));
        logger.info("target = " + target);
        if (nums.length < 3 || nums[0] + nums[1] + nums[2] > target) {
            return 0;
        }
        return helper(nums, target, 0, 1, nums.length - 1, Integer.MAX_VALUE);
    }

    private int helper(int[] nums, int target, int i, int left, int right, int res) {
        if (left == right) {
            i++;
            if (i == nums.length - 2) {
                return res;
            }
            left = i + 1;
            right = nums.length - 1;
        }
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
            return target;
        } else if (sum < target) {
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            left++;
        } else {
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }
            right--;
        }
        res = Math.abs(target - res) < Math.abs(target - sum) ? res : sum;
        return helper(nums, target, i, left, right, res);
    }
}
