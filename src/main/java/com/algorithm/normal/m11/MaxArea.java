package com.algorithm.normal.m11;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * @author sunchen
 * @date 2021/1/5 10:45 ����
 */
public class MaxArea {

    public int handler(int[] height) {
        int sum;
        int max = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
            sum = (high - low) * Math.min(height[low], height[high]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
