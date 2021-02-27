package com.algorithm.normal.m1438;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LongestSubarray: 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * @author sunchen
 * @date 2021/2/25 10:47 下午
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<>();
        Deque<Integer> queMin = new LinkedList<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < nums.length) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]){
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]){
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);

            while (!queMax.isEmpty() && ! queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (queMin.peekFirst() == nums[left]) {
                    queMin.pollFirst();
                }
                if (queMax.peekFirst() == nums[left]) {
                    queMax.pollFirst();
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
