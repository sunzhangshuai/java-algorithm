package com.algorithm.normal.m222;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CountNodes: 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * @author sunchen
 * @date 2021/2/6 10:45 下午
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if (node.left == null) {
                return count*2-1;
            } else if (node.right == null) {
                return count*2;
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return count;
    }
}
