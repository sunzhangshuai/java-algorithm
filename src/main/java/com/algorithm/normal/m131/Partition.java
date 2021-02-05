package com.algorithm.normal.m131;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition:分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * @author sunchen
 * @date 2021/2/6 12:47 上午
 */
public class Partition {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            List<String> list = new ArrayList<>();
            List<List<String>> lists = new ArrayList<>();
            lists.add(list);
            return lists;
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            //取出前面部分
            String sub = s.substring(0,i+1);
            //前面不是回文，结束
            if (!isPalindrome(sub)) {
                continue;
            }
            //获取后面部分的所有组合
            List<List<String>> rightList = partition(s.substring(i+1));
            List<List<String>> newList = new ArrayList<>();
            //拼接上前面部分
            for (List<String> right : rightList) {
                List<String> newRight = new ArrayList<>();
                newRight.add(sub);
                newRight.addAll(right);
                newList.add(newRight);
            }
            result.addAll(newList);
        }
        return result;
    }

    public boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse.equals(s);
    }
}
