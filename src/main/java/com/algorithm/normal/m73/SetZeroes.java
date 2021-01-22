package com.algorithm.normal.m73;

/**
 * SetZeroes:
 *
 * @author sunchen
 * @date 2021/1/22 9:13 下午
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        //第一行有零，则为true
        boolean flushFirstRow = false;
        //第一列有零，则为true
        boolean flushFirstCol = false;
        int row = matrix.length;
        int col = matrix[0].length;
        //判断第一行是否有0
        for (int[] rowNums : matrix) {
            if (rowNums[0] == 0) {
                flushFirstCol = true;
                break;
            }
        }

        //判断第一列是否有0
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                flushFirstRow = true;
                break;
            }
        }
        //遍历其他行，如果存在零，用第一行或者第一列来标识
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //用第一行和第一列 来记录 哪些行 或 列需要置为0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flushFirstRow) {
            //第一行置0
            for (int j = 0; j < col; j++) {
                matrix[0][j]=0;
            }
        }

        if (flushFirstCol) {
            //第一列置0
            for (int i = 0; i < row; i++) {
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }
}
