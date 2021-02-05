package com.algorithm.normal.m95;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateTrees: 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树
 *
 * @author sunchen
 * @date 2021/1/18 10:37 下午
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getList(1, n);
    }

    public List<TreeNode> getList(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            // 获取i左边组合
            List<TreeNode> leftList = getList(start, i - 1);
            // 获取i右边组合
            List<TreeNode> rightList = getList(i + 1, end);

            for (TreeNode value : leftList) {
                for (TreeNode treeNode : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = value;
                    node.right = treeNode;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
