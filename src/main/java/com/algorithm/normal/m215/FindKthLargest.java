package com.algorithm.normal.m215;

/**
 * FindKthLargest: 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @author sunchen
 * @date 2021/1/31 10:54 下午
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        //先建立k个数的小顶堆，然后依次加入后面的元素，淘汰堆中最小的元素
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                create(nums, k - 1, 0);
            }
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            create(nums, k-1, i);
        }
    }

    public void create(int[] nums, int k, int i) {
        while (2 * i + 1 <= k) {
            int j = 2 * i + 1;
            if (2 * i + 2 <= k && nums[2 * i + 1] > nums[2 * i + 2]) {
                j = 2 * i + 2;
            }
            if (nums[i] <= nums[j]) {
                break;
            }
            //和其交换
            swap(nums, i, j);
            i = j;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
