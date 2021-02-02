package com.algorithm.normal.m18;

import java.util.ArrayList;
import java.util.List;

/**
 * FourSums:
 * 给定一个包含n 个整数的数组nums和一个目标值target，
 * 判断nums中是否存在四个元素 a，b，c和 d，
 * 使得a + b + c + d的值与target相等？
 * 找出所有满足条件且不重复的四元组。
 * @author sunchen
 * @date 2020/7/15 2:57 下午
 */
public class FourSums {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //排序
        for (int i = 0; i < nums.length; i++) {
            int tempIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[tempIndex] > nums[j]) {
                    tempIndex = j;
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[tempIndex];
            nums[tempIndex] = temp;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            int needKey = target - nums[i];
            int j = i;
            for (j = i + 1; j < nums.length; j++) {
                int need = needKey - nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum < need) {
                        low++;
                    } else if (sum > need) {
                        high--;
                    } else {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[low]);
                        result.add(nums[high]);
                        list.add(result);
                        if (nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                        if (nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    }
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }
}
