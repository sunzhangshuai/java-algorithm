package com.algorithm.normal.m889;

/**
 * ConstructFromPrePost:
 *
 * @author sunchen
 * @date 2021/2/21 7:03 下午
 */
public class ConstructFromPrePost {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, 0, post, 0, post.length);
    }

    public TreeNode dfs(int[] pre, int preStart, int[] post, int postStart, int length) {
        if (length <= 0) {
            return null;
        }
        //获取根
        TreeNode node = new TreeNode(pre[preStart]);
        if (length == 1) {
            return node;
        }
        //获取根的左子树的根
        int leftRoot = pre[preStart + 1];
        //获取左子树的长度
        int leftLength = 0;
        for (int i = 0; i < length; i++) {
            if (post[postStart + i] == leftRoot) {
                leftLength = i + 1;
            }
        }
        node.left = dfs(pre, preStart + 1, post, postStart, leftLength);
        node.right = dfs(pre, preStart + 1 + leftLength, post, postStart + leftLength, length - leftLength - 1);
        return node;
    }
}
