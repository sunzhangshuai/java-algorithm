package com.algorithm.normal.m306;

/**
 * IsAdditiveNumber: 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * @author sunchen
 * @date 2021/1/24 10:09 下午
 */
public class IsAdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        // 长度小于3的一定不是累加数
        if (num.length() < 3) {
            return false;
        }
        // 第一个数的最大长度
        int num1_max = num.charAt(0) == '0' ? 1 : num.length() / 2;
        for (int i = 0; i < num1_max; i++) {
            String num1 = num.substring(0, i + 1);
            // 第二个数的最大长度
            int num2_max = num.charAt(i + 1) == '0' ? 1 : num.substring(i + 1).length() / 2;
            for (int j = i + 1; j < i + 1 + num2_max; j++) {
                String num2 = num.substring(i + 1, j + 1);
                if (check(num1, num2, num.substring(j + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(String sub1, String sub2, String sub3) {
        // 第三个数的最小长度
        int min = Math.max(sub1.length(), sub2.length());
        // 剩余长度不够
        if (sub3.length() < min) {
            return false;
        }
        // 第三个数的最大长度
        int max = sub3.charAt(0) == '0' ? 1 : sub3.length();
        for (int i = min - 1; i < max; i++) {
            long int1 = Long.parseLong(sub1);
            long int2 = Long.parseLong(sub2);
            long int3 = Long.parseLong(sub3.substring(0, i + 1));
            if (int3 == int2 + int1) {
                return sub3.length() == i + 1 || check(sub2, sub3.substring(0, i + 1), sub3.substring(i + 1));
            } else if (int3 > int2 + int1) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("121474836472147483648"));
        ;
    }
}
