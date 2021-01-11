package com.algorithm.normal.m82;

/**
 * DeleteDuplicates:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * @author sunchen
 * @date 2021/1/5 10:45 ����
 */
public class DeleteDuplicates {
    public ListNode handler(ListNode head){
        if (head == null) {
            return null;
        }
        //增加哨兵，为了避免head变动
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode currentNode = head;
        ListNode pre = sentry;
        while (currentNode != null) {
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode = currentNode.next;
            }
            if(pre.next != currentNode){
                pre.next = currentNode.next;
            }else{
                //确定currentCode没有重复，更新pre
                pre = currentNode;
            }
            currentNode = currentNode.next;
        }
        return sentry.next;
    }
}
