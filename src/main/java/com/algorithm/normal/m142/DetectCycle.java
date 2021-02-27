package com.algorithm.normal.m142;

/**
 * DetectCycle:
 *
 * @author sunchen
 * @date 2021/2/27 4:29 下午
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //说明有环
        if (fast != null) {
            slow = head;
            while (slow != null && fast != null) {
                if (slow == fast){
                    break;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }
        return fast;
    }
}
