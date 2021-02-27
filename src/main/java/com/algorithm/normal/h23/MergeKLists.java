package com.algorithm.normal.h23;

/**
 * MergeKLists: 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @author sunchen
 * @date 2021/2/27 4:47 下午
 */
public class MergeKLists {

    private ListNode[] minHeap;

    private int length;

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        createHeap(lists);
        while (length > 0) {
            ListNode node = minHeap[0];
            list.next = node;
            list = node;
            //如果链表为空，minHeap的最后一个填补第一个
            if (node.next == null) {
                minHeap[0] = minHeap[--length];
            } else {
                minHeap[0] = node.next;
            }
            heap(0);
        }
        return head.next;
    }

    public void createHeap(ListNode[] lists) {
        minHeap = new ListNode[lists.length];
        for (ListNode list : lists) {
            if (list != null) {
                minHeap[length++] = list;
            }
        }
        int start = length / 2 - 1;
        for (int i = start; i >= 0; i--) {
            heap(i);
        }
    }

    public void heap(int index) {
        ListNode listNode = minHeap[index];
        while (index * 2 + 1 < length) {
            // 兼容左右
            int nextIndex = index * 2 + 1;
            if (nextIndex + 1 < length) {
                nextIndex = minHeap[nextIndex].val < minHeap[nextIndex + 1].val ? nextIndex : nextIndex + 1;
            }
            // 比较
            if (listNode.val <= minHeap[nextIndex].val) {
                break;
            }
            minHeap[index] = minHeap[nextIndex];
            index = nextIndex;
        }
        minHeap[index] = listNode;
    }
}
