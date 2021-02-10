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
    public ListNode last;

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
        instance = this;
        List<Integer> list = new ArrayList();
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
            return new ListNode(x);
        }
        last = new ListNode(x);
        return helper(this, x);
    }

    public ListNode helper(ListNode node, Object obj) {
        if (node == null) {
            return new ListNode(obj);
        }
        node.next = helper(node.next, obj);
        return node;
    }

    public boolean contains(int x) {
        if (val == -1) {
            return false;
        }
        if (val == x) {
            return true;
        }
        return next == null ? false : next.contains(x);
    }

    public static ListNode get(int... nums) {
        return new ListNode().push(nums);
    }
}
