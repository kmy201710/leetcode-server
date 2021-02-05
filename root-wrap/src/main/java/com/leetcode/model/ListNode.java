package com.leetcode.model;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public String name;
    public ListNode next;

    public ListNode() {
        val = -1;
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, String s) {
        val = x;
        name = s;
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

    public ListNode helper(ListNode node, int x) {
        if (node == null) {
            return new ListNode(x);
        } else {
            node.next = helper(node.next, x);
        }
        return node;
    }

    public static ListNode get(Roman r) {
        ListNode head = null, tail = null;
        for (int i = 0; i < 7; i++) {
            if (head == null) {
                head = tail = new ListNode(r.num[i], r.str[i]);
            } else {
                tail.next = new ListNode(r.num[i], r.str[i]);
                tail = tail.next;
            }
        }
        return head;
    }
}
