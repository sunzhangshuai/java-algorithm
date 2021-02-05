package com.algorithm.normal.m90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SubsetsWithDup:子集
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * @author sunchen
 * @date 2021/1/22 12:43 上午
 */
public class SubsetsWithDup {
    //记录从哪里开始遍历结果集中的元素
    int point = 0;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return getList(nums, nums.length);
    }

    public List<List<Integer>> getList(int[] nums, int length) {
        if (length == 0) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            point = 0;
            return result;
        }
        // 获取到n-1个数的结果集
        List<List<Integer>> result = getList(nums, length - 1);
        int num = result.size();
        int start = 0;
        // 如果当前元素和前一个元素相等，起点从point开始
        if (length > 1 && nums[length - 1] == nums[length - 2]) {
            start = point;
        }
        // 更新point
        point = num;
        for (int i = start; i < num; i++) {
            List<Integer> list = new ArrayList<>(result.get(i));
            list.add(nums[length - 1]);
            result.add(list);
        }
        return result;
    }
}
