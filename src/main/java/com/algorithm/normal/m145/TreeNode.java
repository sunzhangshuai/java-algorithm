package com.algorithm.normal.m145;

/**
 * TreeNode:
 *
 * @author sunchen
 * @date 2021/1/29 10:29 下午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
