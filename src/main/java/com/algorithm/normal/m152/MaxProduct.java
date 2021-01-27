package com.algorithm.normal.m152;

/**
 * MaxProduct:乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @author sunchen
 * @date 2021/1/27 10:51 下午
 */
public class MaxProduct {
    // 因为是乘积，所以负负会得正，需要记录最小乘积
    public int maxProduct(int[] nums) {
        //存储最大乘积
        int max = nums[0];
        //存储最小乘积
        int min = nums[0];
        //目前的乘积
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mn = min; int mx = max;
            // 3个数比大小：最小乘积*当前值；最大乘积*当前值 ；当前值
            max = Math.max(mn * nums[i], Math.max(nums[i], mx * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            sum = Math.max(max, sum);
        }
        return sum;
    }
}
