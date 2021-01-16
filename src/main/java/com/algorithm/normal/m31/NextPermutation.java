package com.algorithm.normal.m31;

/**
 * NextPermutation: 下一个排列
 *  
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *  
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *  
 * 必须 原地 修改，只允许使用额外常数空间。
 *  
 *  
 * 示例 1：
 *  
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * @author sunchen
 * @date 2021/1/16 7:30 下午
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int swapIndex = -1;
        // 第一步，找出第一个要变化的节点。
        // 规律是  「从后向前」第一个「趋势向下」的节点。 通过1、2、3、4写一遍可知
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swapIndex = i - 1;
                break;
            }
        }

        // 第二步，将index后面的节点从下到大排列
        // 由于index是第一个「趋势向下」的节点，则后面的节点必是由大到小，排序方式可优化（前后双指针交换）
        int start = swapIndex + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        if (swapIndex == -1) {
            return;
        }

        // 第三步，从「index后面」的节点中，找一个比「index位置的值」大的数里面的最小值，和index交换。
        // index为-1时，不需要交换
        for (int i = swapIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[swapIndex]) {
                int temp = nums[swapIndex];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }
}
