package com.algorithm.normal.m287;

/**
 * FindDuplicate:寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数
 * @author sunchen
 * @date 2021/1/28 11:33 下午
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums[i]) {
                continue;
            }
            //深度优先遍历：
            int index = nums[i];
            nums[i] = 0;
            while (index != 0) {
                if (index == nums[index - 1]) {
                    return index;
                }
                int temp = nums[index - 1];
                nums[index - 1] = index;
                index = temp;
            }
        }
        return 0;
    }
}
