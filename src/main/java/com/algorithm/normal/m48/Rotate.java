package com.algorithm.normal.m48;

/**
 * Rotate: 旋转图像
 * 给定一个 n{×{n 的二维矩阵{matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @author sunchen
 * @date 2021/2/1 11:42 下午
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            int start = i;
            int end = n - 1 - i;
            int step = n - (2 * i + 1);
            for (int j = start; j < end; j++) {
                int startValue = matrix[i][j];
                //上---》右
                int step1 = end - j;
                int step2 = step - step1;
                int target = matrix[start + step2][end];
                matrix[start + step2][end] = startValue;
                //右---》下
                int step3 = end - step2 - start ;
                int step4 = step - step3;
                int target2 = matrix[end][end - step4];
                matrix[end][end - step4] = target;
                //下---左
                int step5 = end - step4;
                int step6 = step - step5;
                int target3 = matrix[end - step6-start][start];
                matrix[end - step6-start][start] = target2;
                //左---上
                matrix[i][j] = target3;
            }
        }
    }
}
