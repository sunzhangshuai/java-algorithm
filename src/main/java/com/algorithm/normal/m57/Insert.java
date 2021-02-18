package com.algorithm.normal.m57;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert: 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @author sunchen
 * @date 2021/2/18 8:42 下午
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 新区间的左
        int left = newInterval[0];
        // 新区间的右
        int right = newInterval[1];
        // 新区间是否已经插入
        boolean hasReplace = false;
        List<int[]> newList = new ArrayList<>();
        for (int[] interval : intervals) {
            // 在插入区间的左侧，且无交集，直接新区间
            if (interval[0] > right) {
                if (!hasReplace) {
                    newList.add(new int[]{left, right});
                    hasReplace = true;
                }
                //插入当前区间
                newList.add(interval);
            } else if (interval[1] < left) {
                // 新区间在当前区间的右侧，且无交集，直接插入当前区间
                newList.add(interval);
            } else {
                // 新区间与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!hasReplace) {
            newList.add(new int[]{left, right});
        }
        int[][] array = new int[newList.size()][2];
        for (int i = 0; i < newList.size(); ++i) {
            array[i] = newList.get(i);
        }
        return array;
    }
}
