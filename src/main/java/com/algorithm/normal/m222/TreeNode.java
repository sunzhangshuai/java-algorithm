package com.algorithm.normal.m222;

/**
 * TreeNode:
 *
 * @author sunchen
 * @date 2021/2/6 10:46 下午
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
