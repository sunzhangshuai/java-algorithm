package com.algorithm.normal.m394;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DecodeString:
 *
 * @author sunchen
 * @date 2021/1/19 11:32 下午
 */
public class DecodeString {
    LinkedList<String> list = new LinkedList();
    StringBuffer newSb = new StringBuffer();
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        for (char i : chars) {
            //如果是数字
            if (Character.isDigit(i) || Character.isLetter(i) || i == '[') {
                list.addLast(String.valueOf(i));
            } else {
                //出站，并且按照次数生成对应的字符串
                String data = list.pollLast();
                StringBuffer sb = new StringBuffer();
                LinkedList<String> ss = new LinkedList();
                while (!data.equals("[")){
                    sb.append(data);
                    ss.addFirst(data);
                    data = list.pollLast();
                }
                LinkedList<String> value = new LinkedList<>();
                while (data.compareTo("1") >= 0 && data.compareTo("9") <= 0){
                    value.addFirst(data);
                    data = list.pollLast();
                }
                if (data != null) {
                    list.addLast(data);
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (String ff:value) {
                    stringBuffer.append(ff);
                }
                Integer count = Integer.valueOf(stringBuffer.toString());
                List<String> ddd = new ArrayList<>();
                int start = newSb.length();
                for (int z = 0; z < count; z++) {
                    for (String va:ss) {
                        ddd.add(va);
                        newSb.append(va);
                    }
                    //newSb.append(sb);
                }
                if (!list.isEmpty()) {
                    for (String s1:ddd) {
                        list.addLast(s1);
                    }
                    //把原来添加的删除掉
                    newSb.delete(start, start+ddd.size());
                }
            }
        }
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                newSb.append(list.get(i));
            }
        }
        return newSb.toString();
    }

    public static void main(String[] args) {


        DecodeString dd = new DecodeString();
        System.out.println(dd.decodeString("2[abc]3[cd]ef"));;


    }
}
