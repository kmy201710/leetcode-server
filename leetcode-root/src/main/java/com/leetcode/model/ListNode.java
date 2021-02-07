package com.leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public String name;
    public ListNode next;

    public static ListNode instance = null;

    public ListNode() {
        val = -1;
    }

    public ListNode(Object obj) {
        if (obj instanceof Integer) {
            this.val = (Integer) obj;
        } else {
            this.name = (String) obj;
        }
    }

    public ListNode(int x, String s) {
        this.val = x;
        this.name = s;
    }

    public int[] popVal() {
        if (val == -1) {
            return null;
        }
        List<Integer> list = new ArrayList();
        list.add(val);
        instance = next;
        while (instance != null) {
            list.add(instance.val);
            instance = instance.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public ListNode push(int... nums) {
        instance = this;
        for (int i = 0; i < nums.length; i++) {
            instance = instance.push(nums[i]);
        }
        return instance;
    }

    public ListNode push(int x) {
        if (val == -1) {
            return helper(null, x);
        }
        return helper(this, x);
    }

    public ListNode helper(ListNode node, Object obj) {
        if (node == null) {
            return new ListNode(obj);
        }
        node.next = helper(node.next, obj);
        return node;
    }

    public static ListNode get(int... nums) {
        return new ListNode().push(nums);
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
