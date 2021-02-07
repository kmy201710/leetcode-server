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
        List<Integer> list = new ArrayList();
        list.add(val);
        instance = left;
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
            instance = instance.push(3, nums[i]);
        }
        return instance;
    }

    public TreeNode push(int level, int x) {
        if (val == -1) {
            return helper(null, level, x);
        }
        return helper(this, level, x);
    }

    public TreeNode helper(TreeNode node, int level, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (level == x) {
            node.left = helper(node.left, level, -1);
        } else {
            node.left = helper(node.left, level, x);
        }
        node.right = helper(node.right, level, x);
        return node;
    }

    public static TreeNode get(int... nums) {
        return new TreeNode().push(nums);
    }
}
