package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hhe
 * @Date  2021/2/3 17:35
 * @Description 题库
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] arr = {map.get(target - nums[i]), i};
                return arr;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        // 模拟输入
        int n = MockUtils.get(100);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(0, 100, n);
        System.out.println("nums = " + Arrays.toString(nums));

        int[] result = new Solution001().twoSum(nums, 50);
        System.out.println("result = " + result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " - " + nums[result[i]]);
        }
        System.out.println("=====end=====");
    }
}
