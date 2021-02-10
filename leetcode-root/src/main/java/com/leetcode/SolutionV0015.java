package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 15. 三数之和（中等）
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0015 {
    private static Logger logger = Logger.getLogger(SolutionV0015.class);

    private static List<int[]> list = new ArrayList<>();

    public SolutionV0015(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(-10, 10, n);
        logger.info("nums = " + Arrays.toString(nums));

        threeSum(nums, 0);
        logger.info("threeSum = ");
        list.stream().forEach(p -> {
            logger.info(Arrays.toString(p));
        });
        logger.info("=====end=====");
    }

    public void threeSum(int[] nums, int target) { // public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        logger.info("nums = " + Arrays.toString(nums));
        if (nums.length < 3 || nums[0] + nums[1] + nums[2] > 0) {
            return;
        }
        helper(nums, target, 0, 1, nums.length - 1);
    }

    private void helper(int[] nums, int target, int i, int left, int right) {
        if (left == right) {
            i++;
            if (i == nums.length - 2) {
                return;
            }
            left = i + 1;
            right = nums.length - 1;
        }
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
            list.add(new int[]{nums[i], nums[left], nums[right]});
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            left++;
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
        helper(nums, target, i, left, right);
    }
}
