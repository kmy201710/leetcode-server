package com.leetcode.model;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = -1;
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode push(int x) {
        if (val == -1) {
            return helper(null, x);
        }
        return helper(this, x);
    }

    public static ListNode helper(ListNode node, int x) {
        if (node == null) {
            return new ListNode(x);
        } else {
            node.next = helper(node.next, x);
        }
        return node;
    }
}
