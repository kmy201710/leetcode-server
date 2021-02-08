package com.leetcode.model;

/**
 * @Author hhe
 * @Date 2021/2/5 21:40
 * @Description 罗马数字
 */
public class Roman {
    public static int[] nums = {1000, 500, 100, 50, 10, 5, 1};
    public static String[] strs = {"M", "D", "C", "L", "X", "V", "I"};

    public ListNode node;

    public Roman(ListNode node) {
        this.node = node;
    }

    public static Roman get() {
        ListNode head = null, tail = null;
        for (int i = 0; i < 7; i++) {
            if (head == null) {
                head = tail = new ListNode(nums[i], strs[i]);
            } else {
                tail.next = new ListNode(nums[i], strs[i]);
                tail = tail.next;
            }
        }
        return new Roman(head);
    }
}

