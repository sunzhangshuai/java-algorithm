package com.algorithm.normal.m91;

import java.util.HashMap;

/**
 * NumDecodings:解码方法
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @author sunchen
 * @date 2021/2/25 12:06 上午
 */
public class NumDecodings {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return helper(0, s);
    }

    public int helper(int start, String s) {
        if (start < s.length() && s.charAt(start) == '0') {
            return 0;
        }
        if (start >= s.length() - 1) {
            return 1;
        }
        int count;
        if (!map.containsKey(start)) {
            if (Integer.parseInt(s.substring(start, start + 2)) > 26) {
                count = helper(start + 1, s);
            } else {
                count = helper(start + 1, s) + helper(start + 2, s);
            }
            map.put(start, count);
        }
        return map.get(start);
    }
}
