package com.algorithm.normal.m153;

/**
 * FindMin:
 *
 * @author sunchen
 * @date 2021/1/5 10:45 ����
 */
public class FindMin {
    public int handler(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int middle = (low+high)/2;
            if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
