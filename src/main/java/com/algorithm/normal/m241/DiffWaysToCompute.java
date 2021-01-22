package com.algorithm.normal.m241;

import java.util.ArrayList;
import java.util.List;

/**
 * DiffWaysToCompute:为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
 *
 * @author sunchen
 * @date 2021/1/22 11:41 下午
 */
public class DiffWaysToCompute {
    /**
     * 每个运算符 左右分成两部分，递归获取两部分的所有结果集，再合并结果集
     * @param input
     * @return
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        //如果input是数字，把数字存到list中
        if (isInteger(input)) {
            result.add(Integer.parseInt(input));
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            String sub = input.substring(i, i + 1);
            if (sub.equals("+") || sub.equals("-") || sub.equals("*") || sub.equals("/")) {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        switch (sub) {
                            case "+":
                                result.add(left + right);
                                break;
                            case "-":
                                result.add(left - right);
                                break;
                            case "*":
                                result.add(left * right);
                                break;
                            case "/":
                                result.add(left / right);
                                break;
                        }
                    }

                }
            }
        }
        return result;
    }

//    public static boolean isInteger(String str) {
//        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//        return pattern.matcher(str).matches();
//    }

    public static boolean isInteger(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("2*3-4*5");
        System.out.println(list);
    }
}
