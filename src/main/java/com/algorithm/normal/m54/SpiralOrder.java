package com.algorithm.normal.m54;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralOrder: 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * @author sunchen
 * @date 2021/1/14 1:12 上午
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> data = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                data.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                data.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && data.size() < matrix[0].length * matrix.length; i--) {
                data.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && data.size() < matrix[0].length * matrix.length; i--) {
                data.add(matrix[i][left]);
            }
            left++;
        }

        return data;
    }
}
