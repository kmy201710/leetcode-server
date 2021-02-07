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
 * @Description 4. 寻找两个正序数组的中位数（困难）
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0004 {
    private static Logger logger = Logger.getLogger(SolutionV0004.class);

    public SolutionV0004() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums1 = RandomUtils.randomCommon2(n);
        int[] nums2 = RandomUtils.randomCommon2(nums1[0]);
        logger.info("nums1 = " + Arrays.toString(nums1));
        logger.info("nums2 = " + Arrays.toString(nums2));

        double result = findMedianSortedArrays(nums1, nums2);
        logger.info("findMedianSortedArrays = " + result);
        logger.info("=====end=====");
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ListNode l1 = ListNode.get(nums1), l2 = ListNode.get(nums2);
        List<Integer> list = new ArrayList();
        helper(l1, l2, list);

        int count = list.size();
        if (count % 2 == 0) {
            return (list.get(count / 2 - 1) + list.get(count / 2)) / 2.0;
        } else {
            return list.get(count / 2);
        }
    }

    private List<Integer> helper(ListNode l1, ListNode l2, List list) {
        if (l1 == null && l2 == null) {
            return list;
        }
        int n1 = l1 != null ? l1.val : 0;
        int n2 = l2 != null ? l2.val : 0;

        if (l1 == null) {
            list.add(n2);
            l2 = l2.next != null ? l2.next : null;
        } else if (l2 == null) {
            list.add(n1);
            l1 = l1.next != null ? l1.next : null;
        } else if (n1 < n2) {
            list.add(n1);
            l1 = l1.next != null ? l1.next : null;
        } else {
            list.add(n2);
            l2 = l2.next != null ? l2.next : null;
        }
        return helper(l1, l2, list);
    }
}
