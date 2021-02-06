package com.algorithm.normal.m80;

/**
 * RemoveDuplicates: 删除排序数组中的重复项 II
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author sunchen
 * @date 2021/2/6 11:03 下午
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return 2;
        }
        boolean flag = false;
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                if (!flag) {
                    swap(nums, fast, ++slow);
                    flag = true;
                }
            } else {
                swap(nums, fast, ++slow);
                flag = false;
            }
            fast++;
        }
        return slow + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
