package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 题库
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution344 {
    private static ListNode node = new ListNode();

    public void reverseArray(int[] s) {
        helper(s, 0);
    }

    private void helper(int[] s, int index) {
        if (s.length == index) {
            return;
        }
        helper(s, index + 1);
        node = node.push(s[index]);
    }

    public static void main(String[] args) {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(0, 10, n);
        System.out.println("nums = " + Arrays.toString(nums));

        new Solution344().reverseArray(nums);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("=====end=====");
    }
}
