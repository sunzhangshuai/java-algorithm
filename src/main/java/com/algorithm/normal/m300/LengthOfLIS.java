package com.algorithm.normal.m300;

/**
 * LengthOfLIS: 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * @author sunchen
 * @date 2021/1/16 8:34 下午
 */
public class LengthOfLIS {

    /**
     * 方案一：动态规划
     * dp数组中记录数组中每一个值结尾的子序列的最大长度
     * 遍历nums数组，每次以nums[i]结尾的子序列的长度为基础 更新i后面 比nums[i]大的值的最大子序列长度
     * 时间复杂度为o(n*2)
     *
     * 方案二：动态规划+二分
     * 1. dp数组中记录 子序列长度为i的最后一位的最小值
     * 2. 如果d[len] > nums[i] len=len+1
     * 3. 如果d[len] < nums[i] 二分查找 d[1]-d[len]中 大于nums[i]的最小值
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int d[] = new int[nums.length+1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < d[len]) {
                //从d[i-1]到d[i]中找到一个数
                int start = binarySearch(d, len, nums[i]);
                d[start] = nums[i];
            } else if (nums[i] > d[len]){
                len = len+1;
                d[len] = nums[i];
            }
        }
        return len;
    }

    /**
     * 从d[1]-d[len]中找到一个比target大的最小值
     * @param d
     * @param len
     * @param target
     * @return
     */
    public int binarySearch(int [] d, int len, int target){
        int start = 1;
        int end = len;
        while (start <= end) {
            int mid = (start + end)/2;
            if (d[mid] < target) {
                start = mid +1;
            }else if (d[mid] > target){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return start;
    }
}
