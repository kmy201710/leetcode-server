package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 1. 两数之和（简单）
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0001 {
    private static Logger logger = Logger.getLogger(SolutionV0001.class);

    private static List<int[]> list = new ArrayList<>();

    public SolutionV0001(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(-10, 10, n);
        logger.info("nums = " + Arrays.toString(nums));

        twoSum(nums, 0);
        logger.info("twoSum = ");
        list.stream().forEach(p -> {
            logger.info(Arrays.toString(p));
        });

        int[] nums1 = RandomUtils.randomCommon(-10, 10, n);
        int[] nums2 = RandomUtils.randomCommon(-10, 10, n);
        logger.info("nums1 = " + Arrays.toString(nums1));
        logger.info("nums2 = " + Arrays.toString(nums2));
        int result = twoSumCount(nums1, nums2);
        logger.info("twoSumCount = " + result);
        logger.info("=====end=====");
    }

    public void twoSum(int[] nums, int target) { // public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        logger.info("nums = " + Arrays.toString(nums));
        logger.info("target = " + target);
        if (nums.length < 2 || nums[0] + nums[1] > target) {
            return;
        }
        helper(nums, target, 0, nums.length - 1);
    }

    private void helper(int[] nums, int target, int left, int right) {
        if (left == right) {
            return;
        }
        int sum = nums[left] + nums[right];
        if (sum == target) {
            list.add(new int[]{left, right, nums[left], nums[right]});
            return;
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
        helper(nums, target, left, right);
    }

    public int twoSumCount(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res += map.get(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) + 1);
                continue;
            }
            map.put(nums1[i], 1);
            res += helper(nums2, nums1[i], 0, nums2.length - 1, 0);
            logger.info("helper = " + res);
        }
        return res;
    }

    private int helper(int[] nums, int target, int left, int right, int res) {
        if (left == right) {
            return res;
        }
        int sum = nums[left];
        if (sum + target == 0) {
            res++;
        }
        left++;
        return helper(nums, target, left, right, res);
    }
}
