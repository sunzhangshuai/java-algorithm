package com.algorithm.normal.m375;

import java.util.HashMap;

/**
 * GetMoneyAmount: 猜数字大小 II
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从1到 n 之间选择一个数字，你来猜我选了哪个数字。
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 * @author sunchen
 * @date 2021/2/7 11:09 下午
 */
public class GetMoneyAmount {
    HashMap<String, Integer> map = new HashMap<>();

    public int getMoneyAmount(int n) {
        return getMoney(1, n);
    }

    public int getMoney(int left, int right) {
        if (left >= right) {
            return 0;
        }
        Integer value = map.get(left + "-" + right);
        if (value == null) {
            int min = Integer.MAX_VALUE;
            for (int i = left; i < right; i++) {
                int max = Math.max(getMoney(left, i - 1), getMoney(i + 1, right)) + i;
                min = Math.min(min, max);
            }
            map.put(left + "-" + right, min);
        }
        return map.get(left + "-" + right);
    }
}
