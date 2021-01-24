package com.algorithm.normal.m321;

/**
 * MaxNumber:拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * @author sunchen
 * @date 2021/1/25 12:21 上午
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            // 获取num1中的最大数
            int[] sub1 = maxSub(nums1, i);
            // 获取num2中的最大数
            int[] sub2 = maxSub(nums2, k - i);
            // 合并两个最大值----》最大数
            int[] curMaxSubsequence = merge(sub1, sub2);
            // 和当前的最大值做比较
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    /**
     * 获取最大数
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSub(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    /**
     * 合并两个数组 得到的数最大
     * @param sub1
     * @param sub2
     * @return
     */
    public int[] merge(int[] sub1, int[] sub2) {
        if (sub1.length == 0) {
            return sub2;
        }
        if (sub2.length == 0) {
            return sub1;
        }
        int[] result = new int[sub1.length + sub2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (compare(sub1, index1, sub2, index2) > 0) {
                result[i] = sub1[index1++];
            } else {
                result[i] = sub2[index2++];
            }
        }
        return result;
    }

    /**
     * 从指定下标开始 比较两个数组大小
     * @param sub1
     * @param index1
     * @param sub2
     * @param index2
     * @return
     */
    public int compare(int[] sub1, int index1, int[] sub2, int index2) {
        int x = sub1.length, y = sub2.length;
        while (index1 < x && index2 < y) {
            int difference = sub1[index1] - sub2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
