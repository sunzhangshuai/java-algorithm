package com.algorithm.normal.m109;

/**
 * TreeNode:
 *
 * @author sunchen
 * @date 2021/3/1 12:26 上午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
