package com.algorithm.normal.m78;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author sunchen
 * @date 2021/1/21 11:36 下午
 */
public class Subsets {
    /**
     * 取出原来的，放入新的
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        result.add(emptyList);
        for (int num : nums) {
            //先取出result中的list
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }


    public static List<List<Integer>> subsets2(int[] nums) {
        return getList(nums, nums.length);
    }

    public static List<List<Integer>> getList(int [] nums, int length){
        if (length == 0) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        // 获取到n-1个数的结果集
        List<List<Integer>> result = getList(nums, length-1);
        // 遍历结果集，拷贝出每一个元素，加入第n个数，再和原结果集合并
        int num = result.size();
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>(result.get(i));
            list.add(nums[length-1]);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3};
        System.out.println(subsets2(nums));
    }
}
