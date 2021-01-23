package com.algorithm.normal.m279;

import java.util.HashSet;
import java.util.Set;

/**
 * NumSquares:完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * @author sunchen
 * @date 2021/1/23 10:29 下午
 */
public class NumSquares {
    Set<Integer> sqrt = new HashSet<>();
    public boolean is_divide_by(int n, int count){
        if (count == 1) {
            return sqrt.contains(n);
        }
        for (int i = 1; i*i <= n; i++) {
            if (is_divide_by(n - i*i, count-1)) {
                return true;
            }
        }
        return false;
    }
    public int numSquares(int n) {
        for (int i = 1; i*i <=n; i++) {
            sqrt.add(i*i);
        }
        for (int i = 1; i <= n; i++) {
            if(is_divide_by(n,i)){
                return i;
            }
        }
        return n;
    }
}
