package com.leetcode.model;

import com.leetcode.utils.EmptyUtils;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public String str;
    public ListNode next;

    public ListNode() {
        val = -1;
    }

    public ListNode(Object x) {
        if (x instanceof Integer) {
            val = (Integer) x;
        } else {
            str = (String) x;
        }
    }

    public ListNode push(int[] nums) {
        ListNode node = new ListNode();
        for (int i = 0; i < nums.length; i++) {
            node = node.push(nums[i]);
        }
        return node;
    }

    public ListNode push(int x) {
        if (val == -1) {
            return helper(null, x);
        }
        return helper(this, x);
    }

    public ListNode push(String x) {
        if (EmptyUtils.isEmpty(str)) {
            return helper(null, x);
        }
        return helper(this, x);
    }

    public static ListNode helper(ListNode node, Object x) {
        if (node == null) {
            return new ListNode(x);
        } else {
            node.next = helper(node.next, x);
        }
        return node;
    }
}
