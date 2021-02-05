package com.algorithm.normal.m866;

/**
 * PrimePalindrome: 回文素数
 * 求出大于或等于N的最小回文素数。
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * 例如，2，3，5，7，11 以及13 是素数。
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * 例如，12321 是回文数。
 *
 * @author sunchen
 * @date 2021/2/5 11:58 下午
 */
public class PrimePalindrome {
    public static int primePalindrome(int n) {
        n = getNextPalindrome(n);
        while (!isPrime(n)) {
            n++;
            n = getNextPalindrome(n);
        }
        return n;
    }

    public static int getNextPalindrome(int n) {
        //1.先反转字符串
        String string = getPalindrome(n);
        int result = Integer.parseInt(string);
        if (result >= n) {
            return result;
        }
        //把前半部分值加1
        int mid = (int) Math.ceil(string.length() / 2.0);
        //转成回文，返回
        n = Integer.parseInt(string.substring(0, mid)) + 1;
        return Integer.parseInt(getPalindrome(Integer.parseInt(n + string.substring(mid))));
    }

    public static String getPalindrome(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            s[s.length - 1 - i] = s[i];
        }
        return String.valueOf(s);
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(13));
    }
}
