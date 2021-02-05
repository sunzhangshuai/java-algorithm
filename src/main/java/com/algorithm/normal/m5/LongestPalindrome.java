package com.algorithm.normal.m5;

/**
 * LongestPalindrome:  最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串
 *
 * @author sunchen
 * @date 2021/1/25 9:59 下午
 */
public class LongestPalindrome {
    // 记录回文开始点
    int index;
    // 计算回文最大长度
    int len;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.substring(0, 1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // bab
            palindromeHelper(i, i, s);
            // abba
            palindromeHelper(i, i + 1, s);
        }
        return s.substring(index, index + len);
    }

    public void palindromeHelper(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (len < right - left - 1) {
            index = left + 1;
            len = right - left - 1;
        }
    }
}
