package com.algorithm.normal.m424;

/**
 * CharacterReplacement:替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * @author sunchen
 * @date 2021/3/1 12:15 上午
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int[] req = new int[26];
        int maxLength = 0;
        while (right < chars.length) {
            req[chars[right]-'A']++;
            maxCount = Math.max(maxCount, req[chars[right]-'A']);
            if (right - left + 1> maxCount + k) {
                req[chars[left]-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
