package com.algorithm.normal.m33;

/**
 * Search:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * @author sunchen
 * @date 2021/1/15 11:23 下午
 */
public class Search {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            //找到了
            if (nums[middle] == target) {
                return middle;
            }
            //左边有序
            if (nums[middle] > nums[high]) {

                //判断在有序区找，还是在无序区找
                if (target < nums[middle] && target >= nums[low]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }

            } else if (nums[middle] < nums[high]) {
                //右边有序

                if (target > nums[middle] && target <= nums[high]) {
                    //在有序区找
                    low = middle + 1;
                } else {
                    //在无序区找
                    high = middle - 1;
                }
            } else {
                // 无法确定哪边有序，但最后一个可以排除
                // 1 1 1 0 1 11
                high--;
            }
        }
        return -1;
    }
}
