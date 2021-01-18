package com.algorithm.normal.m96;

import java.util.HashMap;

/**
 * NumTrees: 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @author sunchen
 * @date 2021/1/18 10:39 下午
 */
public class NumTrees {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int start = 0;
        int end = n - 1;
        int sum = 0;
        Integer value = map.get(n);
        if (value == null) {
            while (start < n) {
                sum += (numTrees(start) * numTrees(end));
                start++;
                end--;
            }
            map.put(n, sum);
        }

        return map.get(n);
    }
}
