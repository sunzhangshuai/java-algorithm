package com.algorithm.normal.m460;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {
    //key：key value:最新的值
    Map<Integer, Node> key_table;
    //key:频率 value:频率相等的结点
    Map<Integer, LinkedList<Node>> freq_table;
    //最小频率
    int minfreq;
    //容量大小
    int capacity;
    public LFUCache(int capacity) {
        this.minfreq = 0;
        this.capacity = capacity;
        key_table = new HashMap<Integer, Node>();
        freq_table = new HashMap<Integer, LinkedList<Node>>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!key_table.containsKey(key)) {
            return -1;
        }
        Node node = key_table.get(key);
        int freq = node.freq;
        int value = node.value;
        //删除已有结点所在的频率链表
        freq_table.get(freq).remove(node);
        if (freq_table.get(freq).size() == 0) {
            freq_table.remove(freq);
            //当前记录的最小频率所在的链表已经为空。更新最小频率值
            if (minfreq == freq) {
                minfreq += 1;
            }
        }
        //在对应的新频率链表中添加结点
        LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<Node>());
        list.offerFirst(new Node(key, value, freq + 1));
        freq_table.put(freq + 1, list);
        key_table.put(key, freq_table.get(freq + 1).peekFirst());
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        //如果key_table中不存在
        if (!key_table.containsKey(key)) {
            //看是否已经满了
            if (capacity == key_table.size()) {
                //获取最小频率所在链表的表尾元素
                Node node = freq_table.get(minfreq).peekLast();
                //从key_table中删除元素
                key_table.remove(node.key);
                //从freg_table中删除元素
                freq_table.get(minfreq).pollLast();
                //如果频率为minfreg的结点已经没了，删除key=minfreg的记录
                if (freq_table.get(minfreq).size() == 0) {
                    freq_table.remove(minfreq);
                }
            }
            //放入新结点：
            Node node = new Node(key, value, 1);
            key_table.put(key, node);
            LinkedList<Node> list = freq_table.getOrDefault(1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, 1));
            freq_table.put(1, list);
            minfreq = 1;
        } else {
            Node oldNode = key_table.get(key);
            //删除已有结点所在的频率链表
            int freq = oldNode.freq;
            freq_table.get(freq).remove(oldNode);
            if (freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                //当前记录的最小频率所在的链表已经为空。更新最小频率值
                if (minfreq == freq) {
                    minfreq += 1;
                }
            }
            //在对应的新频率链表中添加结点
            LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, freq + 1));
            freq_table.put(freq + 1, list);
            //更新key_table的值
            //key_table.put(key, newNode);
            key_table.put(key, freq_table.get(freq + 1).peekFirst());

        }
    }
    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        int i = lFUCache.get(1);// 返回 1
        System.out.println(i);
        lFUCache.put(3, 3);   // 去除键 2
        int i1 = lFUCache.get(2);// 返回 -1（未找到）
        System.out.println(i1);
        int i2 = lFUCache.get(3);// 返回 3
        System.out.println(i2);
        lFUCache.put(4, 4);   // 去除键 1
        int i3 = lFUCache.get(1);// 返回 -1（未找到）
        System.out.println(i3);
        int i4 = lFUCache.get(3);// 返回 3
        System.out.println(i4);
        int i5 = lFUCache.get(4);// 返回 4
        System.out.println(i5);

    }
}

class Node {
    int key;
    int value;
    int freq;
    Node(int key, int val, int freq) {
        this.key = key;
        this.value = val;
        this.freq = freq;
    }
}

