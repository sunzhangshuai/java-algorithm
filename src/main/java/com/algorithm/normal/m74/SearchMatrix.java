package com.algorithm.normal.m74;

/**
 * SearchMatrix:  搜索二维矩阵
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @author sunchen
 * @date 2021/2/21 6:54 下午
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = (left+right)/2;
            int value = matrix[mid/col][mid%col];
            if (value > target) {
                right--;
            } else if (value < target) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
