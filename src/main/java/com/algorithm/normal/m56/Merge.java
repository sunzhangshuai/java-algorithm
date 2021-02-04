package com.algorithm.normal.m56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @author sunchen
 * @date 2021/2/4 11:55 下午
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> mergeList = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            int last = mergeList.size() - 1;
            if (mergeList.size() == 0 || mergeList.get(last)[1] < left) {
                //没有重叠
                mergeList.add(new int[]{left, right});
            } else {
                //取右边最大的
                mergeList.get(last)[1] = Math.max(mergeList.get(last)[1], right);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
