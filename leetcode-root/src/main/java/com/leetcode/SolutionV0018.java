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
 * @Description 18. 四数之和（中等）
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0018 {
    private static Logger logger = Logger.getLogger(SolutionV0018.class);

    private static List<int[]> list = new ArrayList<>();

    public SolutionV0018(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(-10, 10, n);
        logger.info("nums = " + Arrays.toString(nums));

        fourSum(nums, 0);
        logger.info("fourSum = ");
        list.stream().forEach(p -> {
            logger.info(Arrays.toString(p));
        });
        logger.info("=====end=====");
    }

    public void fourSum(int[] nums, int target) { // public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        logger.info("nums = " + Arrays.toString(nums));
        if (nums.length < 4 || nums[0] + nums[1] + nums[2] + nums[3] > target) {
            return;
        }
        helper(nums, target, 0, 1, 2, nums.length - 1);
    }

    private void helper(int[] nums, int target, int i, int j, int left, int right) {
        if (left == right) {
            j++;
            if (j == left  || left == nums.length - 1) {
                i++;
                j = i + 1;
            }
            if (i == nums.length - 3) {
                return;
            }
            left = j + 1;
            right = nums.length - 1;
        }
        int sum = nums[i] + nums[j] + nums[left] + nums[right];
        if (sum == target) {
            list.add(new int[]{nums[i], nums[j], nums[left], nums[right]});
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
        helper(nums, target, i, j, left, right);
    }
}
