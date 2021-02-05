package com.algorithm.normal.m92;

/**
 * ReverseBetween: 翻转链表
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author sunchen
 * @date 2021/1/14 10:34 下午
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        //哨兵结点，指向第一个结点
        ListNode sentry = new ListNode(0);
        sentry.next = head;

        //用于反转的前驱和当前结点
        ListNode pre = null;
        ListNode node = head;

        //链表截断的前一个结点
        ListNode beforeStop = sentry;
        //需要反转的第一个结点
        ListNode afterStop = head;
        int index = 1;

        while (node != null) {
            ListNode next = node.next;
            if (index < m) {
                beforeStop = node;
            } else if (index == m) {
                afterStop = node;

                node.next = pre;
                pre = node;
            } else if (index < n) {
                node.next = pre;
                pre = node;
            } else {
                node.next = pre;
                //串联关系
                beforeStop.next = node;
                afterStop.next = next;
                break;
            }
            node = next;
            index++;
        }
        return sentry.next;
    }
}
