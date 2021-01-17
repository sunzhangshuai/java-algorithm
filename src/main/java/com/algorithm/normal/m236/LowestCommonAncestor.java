package com.algorithm.normal.m236;

/**
 * LowestCommonAncestor:
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author sunchen
 * @date 2021/1/17 9:19 下午
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left, p ,q);
        TreeNode rNode = lowestCommonAncestor(root.right, p ,q);
        if (lNode != null && rNode != null) {
            return root;
        }
        if (lNode != null) {
            return lNode;
        }
        if (rNode != null) {
            return rNode;
        }
        return null;
    }
}
