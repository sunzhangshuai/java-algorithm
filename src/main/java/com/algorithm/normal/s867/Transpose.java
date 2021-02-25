package com.algorithm.normal.s867;

/**
 * Transpose: 矩阵转置
 *
 * @author sunchen
 * @date 2021/2/25 10:42 下午
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int[][] transMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transMatrix[j][i] = matrix[i][j];
            }
        }
        return transMatrix;
    }
}
