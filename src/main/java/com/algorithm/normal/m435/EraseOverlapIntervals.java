package com.algorithm.normal.m435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * EraseOverlapIntervals: 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * @author sunchen
 * @date 2021/1/29 10:49 下午
 */
public class EraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int n = intervals.length;
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
            } else {
                right = Math.min(intervals[i][1],right);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a [][] = {{1,8},{2,3},{7,9}};
        System.out.println(eraseOverlapIntervals(a));
    }
}
