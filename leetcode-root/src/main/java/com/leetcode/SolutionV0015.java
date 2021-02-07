package com.leetcode;

import com.leetcode.model.ListNode;
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

    List<ListNode> list = new ArrayList();

    public SolutionV0015() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(-10, 10, n);
        logger.info("nums = " + Arrays.toString(nums));

        threeSum(nums);
        logger.info("threeSum = ");
        list.stream().forEach(p -> {
            logger.info(Arrays.toString(p.popVal()));
        });
        logger.info("=====end=====");
    }

    public void threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] > 0) {
            return;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            helper(nums, i, i + 1, nums.length - 1);
        }
    }

    private void helper(int[] nums, int index, int left, int right) {
        if (left == right) {
            return;
        }
        int sum = nums[index] + nums[left] + nums[right];
        if (sum == 0) {
            ListNode node = ListNode.get(new int[]{nums[index], nums[left], nums[right]});
            list.add(node);
            return;
        } else if (sum < 0) {
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
        helper(nums, index, left, right);
    }

}
