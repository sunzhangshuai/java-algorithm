package com.algorithm.normal.m61;

/**
 * RotateRight: 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @author sunchen
 * @date 2021/2/2 10:12 下午
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        //找到表尾结点，表尾和表头连在一起
        ListNode oldTail = head;
        int n = 1;
        while(oldTail.next != null){
            oldTail = oldTail.next;
            n++;
        }
        oldTail.next = head;
        //寻找新的表尾
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++){
            newTail = newTail.next;
        }
        //新表头
        ListNode newHead = newTail.next;
        //断开环
        newTail.next = null;
        return newHead;
    }

}
