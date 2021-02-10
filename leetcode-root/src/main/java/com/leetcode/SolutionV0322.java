package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hhe
 * @Date 2021/2/9 11:00
 * @Description 322. 零钱兑换（中等）
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0322 {
    private static Logger logger = Logger.getLogger(SolutionV0322.class);

    public SolutionV0322(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));
        int amount = RandomUtils.randomCommon(max, n);
        logger.info("amount = " + amount);

        int result = coinChange(nums, amount);
        logger.info("coinChange = " + result);
        logger.info("=====end=====");
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        logger.info("coins = " + Arrays.toString(coins));
        if (coins[0] > amount) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = helper(ListNode.get(coins), 0, coins[0], amount, map);
        return res;
    }

    private int helper(ListNode node, int left, int right, int amount, Map<Integer, Integer> map) {
        if (right > amount) {
            return map.getOrDefault(amount, 0);
        }
        int diff = right - left;
        if (diff == node.last.val) {
            int n = map.getOrDefault(left, 0);
            map.put(right, n + 1);
        } else if (diff < node.last.val) {
            if (node.contains(diff)) {
                int nLeft = right - node.last.val;
                for (int i = nLeft; i < right; i++) {
                    if (node.contains(i)) {
                        int pre = map.getOrDefault(right, 0);
                        int n = map.getOrDefault(left, 0);
                        map.put(right, pre == 0 ? n + 1 : Math.min(pre, n + 1));
                        break;
                    }
                }
            }
        } else {
            left++;
            right = left + node.val;
        }
        right++;
        return helper(node, left, right, amount, map);
    }
}
