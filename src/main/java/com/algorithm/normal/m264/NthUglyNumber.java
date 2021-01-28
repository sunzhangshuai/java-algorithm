package com.algorithm.normal.m264;

/**
 * NthUglyNumber:丑数
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * @author sunchen
 * @date 2021/1/28 11:34 下午
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int dp_2 = 0;
        int dp_3 = 0;
        int dp_5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[dp_5] * 5, Math.min(dp[dp_2] * 2, dp[dp_3] * 3));
            if (dp[i] == dp[dp_2] * 2) {
                dp_2++;
            }
            if (dp[i] == dp[dp_3] * 3) {
                dp_3++;
            }
            if (dp[i] == dp[dp_5] * 5) {
                dp_5++;
            }
        }
        return dp[n - 1];
    }
}
