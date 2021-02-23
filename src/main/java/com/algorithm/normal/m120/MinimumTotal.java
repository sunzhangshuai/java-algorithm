package com.algorithm.normal.m120;

import java.util.List;

/**
 * MinimumTotal:三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * @author sunchen
 * @date 2021/2/23 10:10 下午
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //pathSum记录了从第1行到第i行的最短路径
        int[][] pathSum = new int[n][n];
        //初始化第一行
        pathSum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            pathSum[i][0] = pathSum[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            pathSum[i][i] = pathSum[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minSum = pathSum[n - 1][0];
        //获取从第一行到第n行的最短路径
        for (int i = 1; i < n; i++) {
            minSum = Math.min(minSum, pathSum[n - 1][i]);
        }
        return minSum;
    }
}
