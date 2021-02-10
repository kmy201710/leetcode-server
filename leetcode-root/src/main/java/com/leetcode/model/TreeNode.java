package com.leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode last;

    public static TreeNode instance = null;

    public TreeNode() {
        this.val = -1;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int[] popVal() {
        if (val == -1) {
            return null;
        }
        instance = this;
        List<Integer> list = new ArrayList();
        while (instance != null) {
            list.add(instance.val);
            instance = instance.left;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public TreeNode push(int... nums) {
        instance = this;
        for (int i = 0; i < nums.length; i++) {
            instance = instance.push(nums[i]);
        }
        return instance;
    }

    public TreeNode push(int x) {
        if (val == -1) {
            return new TreeNode(x);
        }
        last = new TreeNode(x);
        return helper(this, 5, x);
    }

    public TreeNode helper(TreeNode node, int skip, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (x % skip == 0) {
            node.left = helper(node.left, skip, -1);
        } else {
            node.left = helper(node.left, skip, x);
        }
        node.right = helper(node.right, skip, x);
        return node;
    }

    public boolean contains(int x) {
        if (val == -1) {
            return false;
        }
        if (val == x) {
            return true;
        }
        return left == null ? false : left.contains(x) || right == null ? false : right.contains(x);
    }

    public static TreeNode get(int... nums) {
        return new TreeNode().push(nums);
    }
}
