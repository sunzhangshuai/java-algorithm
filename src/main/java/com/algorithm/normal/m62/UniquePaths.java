package com.algorithm.normal.m62;

import java.util.HashMap;

/**
 * UniquePaths: 不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @author sunchen
 * @date 2021/2/8 11:07 下午
 */
public class UniquePaths {
    HashMap<String, Integer> map = new HashMap();

    public int uniquePaths(int m, int n) {
        if (map.get(m + ":" + n) == null) {
            int[][] f = new int[m][n];
            for (int i = 0; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 0; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            map.put(m + ":" + n, f[m - 1][n - 1]);
        }

        return map.get(m + ":" + n);
    }
}
