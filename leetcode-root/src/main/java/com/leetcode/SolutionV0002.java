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
 * @Date 2021/2/3 17:35
 * @Description 2. 两数相加（中等）
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0002 {
    private static Logger logger = Logger.getLogger(SolutionV0002.class);

    private static List<Integer> list = new ArrayList();

    public SolutionV0002() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums1 = RandomUtils.randomCommon(n);
        int[] nums2 = RandomUtils.randomCommon(nums1[0]);
        logger.info("nums1 = " + Arrays.toString(nums1));
        logger.info("nums2 = " + Arrays.toString(nums2));

        addTwoNumbers(nums1, nums2);
        logger.info("addTwoNumbers = " + list.toString());
        logger.info("=====end=====");
    }

    public void addTwoNumbers(int[] nums1, int[] nums2) {
        ListNode l1 = ListNode.get(nums1), l2 = ListNode.get(nums2);
        int carry = helper(l1, l2, 0);
        if (carry > 0) {
            list.add(carry);
        }
    }

    private int helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry;
        }
        int n1 = l1 != null ? l1.val : 0;
        int n2 = l2 != null ? l2.val : 0;
        int sum = n1 + n2 + carry;
        carry = sum / 10;

        list.add(sum % 10);
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        return helper(l1, l2, carry);
    }
}
