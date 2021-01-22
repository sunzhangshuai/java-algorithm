package com.algorithm.normal.m394;


import java.util.LinkedList;


/**
 * DecodeString: 字符串解码
 * 
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例 1:
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * @author sunchen
 * @date 2021/1/19 11:32 下午
 */
public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> digestList = new LinkedList<>();
        LinkedList<String> letterList = new LinkedList<>();
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int digest = 0;
        for (char i : chars) {
            //数字
            if (Character.isDigit(i)) {
                digest = digest*10+(i-48);
            } else if (Character.isLetter(i)) {
                //字母
                sb.append(i);
            } else if (i == '[') {
                digestList.addLast(digest);
                letterList.addLast(sb.toString());
                digest = 0;
                sb = new StringBuffer();
            } else if (i == ']') {
                int value = digestList.pollLast();
                String str = letterList.pollLast();
                StringBuilder subStr = new StringBuilder();
                for (int x = 0; x < value; x++) {
                    subStr.append(sb.toString());
                }
                sb = new StringBuffer().append(str).append(subStr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        DecodeString dd = new DecodeString();
        System.out.println(dd.decodeString("3[a]2[bc]"));;


    }
}
