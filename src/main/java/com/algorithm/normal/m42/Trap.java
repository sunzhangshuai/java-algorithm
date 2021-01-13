package com.algorithm.normal.m42;

import java.util.ArrayList;
import java.util.List;

/**
 * Trap:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * @author sunchen
 * @date 2021/1/12 11:49 下午
 */
public class Trap {
    /**
     * 思路：累加每个柱子上的存水量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        //lmaxArray数组用于每个柱子左边的最大值
        int lmaxArray[] = new int[height.length];
        int lmax = 0;
        for (int i = 0; i < height.length; i++) {
            lmax = Math.max(lmax, height[i]);
            lmaxArray[i] = lmax;
        }
        int rmax = 0;
        int result = 0;
        for (int i = height.length - 1; i > 0; i--) {
            //计算每个柱子右边的最大值，无需存到数组，直接进行累加
            rmax = Math.max(rmax, height[i]);
            result += Math.min(rmax, lmaxArray[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int a [][] = {{1,2}};
        spiralOrder(a);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> data = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (up <= down){
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
