package com.algorithm.normal.s122;

/**
 * MaxProfit: 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author sunchen
 * @date 2021/1/30 9:30 下午
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                sum += max;
                min = prices[i];
                max = 0;
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        sum += max;
        return sum;
    }
}
