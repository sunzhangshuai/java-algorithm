package com.algorithm.normal.m59;

/**
 * GenerateMatrix:
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author sunchen
 * @date 2021/1/15 12:30 上午
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        int value = 1;
        int result[][] = new int[n][n];
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                result[up][i] = value++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result[i][right] = value++;
            }
            right--;
            for (int i = right; i >= left && value - 1 < Math.pow(n,2); i--) {
                result[down][i] = value++;
            }
            down--;
            for (int i = down; i >= up && value - 1 <  Math.pow(n,2); i--) {
                result[i][left] = value++;
            }
            left++;
        }
        return result;
    }
}
