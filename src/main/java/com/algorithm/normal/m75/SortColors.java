package com.algorithm.normal.m75;

/**
 * SortColors:  颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意：请不要使用代码库中的排序函数来解决这道题。
 * 示例 1：
 *  
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * @author sunchen
 * @date 2021/1/17 7:53 下午
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // p0左边都是0
        int p0 = 0;
        // p1左边都是1或0
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //nums[i],nums[p1],nums[p0]交换
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = nums[p0];
                nums[p0] = temp;
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                //和p1所指的数交换，p1++
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
    }
}
