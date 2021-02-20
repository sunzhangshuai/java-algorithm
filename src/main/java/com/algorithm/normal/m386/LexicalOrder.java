package com.algorithm.normal.m386;

import java.util.ArrayList;
import java.util.List;

/**
 * LexicalOrder:字典序排数
 * 给定一个整数n, 返回从1到n的字典顺序。
 * 例如，
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
 * @author sunchen
 * @date 2021/2/20 11:30 下午
 */
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        int length = Math.min(9, n);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            list.add(i);
            list.addAll(dfs(i * 10, n));
        }
        return list;
    }

    public List<Integer> dfs(int base, int n) {
        List<Integer> list = new ArrayList<>();
        if (base > n) {
            return list;
        }
        int length = Math.min(base + 9, n);
        for (int i = base; i <= length; i++) {
            list.add(i);
            list.addAll(dfs(i * 10, n));
        }
        return list;
    }
}
