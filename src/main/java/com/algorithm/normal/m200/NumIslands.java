package com.algorithm.normal.m200;

/**
 * NumIslands:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * @author sunchen
 * @date 2021/1/27 11:37 下午
 */
public class NumIslands {
    /**
     * 思路： 深度优先遍历无向图， 把垂直方向和水平方向为1的看做有边
     * @param grid 网格
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(i,j,grid);
                }
            }
        }
        return num;
    }

    public void dfs (int row, int col, char[][]grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        //深度遍历他的邻接点
        dfs(row-1, col, grid);
        dfs(row+1, col, grid);
        dfs(row, col-1, grid);
        dfs(row, col+1, grid);
        grid[row][col] = '0';
    }
}
