package com.algorithm.normal.m93;

import java.util.ArrayList;
import java.util.List;

/**
 * RestoreIpAddresses:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * @author sunchen
 * @date 2021/1/25 10:46 下午
 */
public class RestoreIpAddresses {


    public static List<String> restoreIpAddresses(String s) {
        return dfs(s, 4);
    }

    /**
     * @param string
     * @param n 代表有几段
     * @return
     */
    public static List<String> dfs(String string, int n) {
        List<String> res = new ArrayList<>();

        if (string.length() < n || 3 * n < string.length()) {
            return res;
        }

        if (n == 1) {
            if (Integer.parseInt(string) > 255 || (string.length() > 1 && string.charAt(0) == '0')) {
                return res;
            }
            res.add(string);
            return res;
        }

        //每段的最大长度
        int max = Math.min(string.length(), 3);
        for (int i = 0; i < max; i++) {
            String sub = string.substring(0, i + 1);
            //一段最大 255
            if (Integer.parseInt(sub) > 255) {
                break;
            }
            // 获取到n-1段的结果，前面拼上第一段
            List<String> list = dfs(string.substring(i + 1), n - 1);
            for (String s : list) {
                res.add(sub + "." + s);
            }
            // 如果开始是0，则这一段长度只能是1
            if (string.charAt(0) == '0') {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
