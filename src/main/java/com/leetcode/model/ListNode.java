package com.leetcode.model;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode push(ListNode node, int x) {
        if (node == null) {
            return new ListNode(x);
        } else {
            node.next = push(node.next, x);
        }
        return node;
    }
}
