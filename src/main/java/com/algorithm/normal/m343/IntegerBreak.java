package com.algorithm.normal.m343;

import java.util.HashMap;

/**
 * IntegerBreak:整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author sunchen
 * @date 2021/2/27 12:19 上午
 */
public class IntegerBreak {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }
}
