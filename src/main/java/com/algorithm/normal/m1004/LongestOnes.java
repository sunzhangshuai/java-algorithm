package com.algorithm.normal.m1004;

/**
 * LongestOnes: 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * @author sunchen
 * @date 2021/2/19 10:28 下午
 */
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int left = 0;
        // 为了便于计算left和right之间的0，可以把A中的1变成0，0变成1，
        // 然后计算前缀和，再相减，不大于K就满足条件
        // 记录以left为尾的前缀和
        int lPrefixSum = 0;
        // 记录以right为尾的前缀和
        int rPrefixSum = 0;
        //最多包含k个0，把0换成1后 连续1的最大长度
        int maxLength = 0;
        for (int right = 0; right < n; ++right) {
            rPrefixSum += 1 - A[right];
            while (lPrefixSum < rPrefixSum - K) {
                lPrefixSum += 1 - A[left];
                ++left;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
