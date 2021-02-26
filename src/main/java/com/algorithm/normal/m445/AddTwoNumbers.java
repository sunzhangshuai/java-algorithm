package com.algorithm.normal.m445;

import java.util.Deque;
import java.util.LinkedList;

/**
 * AddTwoNumbers: 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * @author sunchen
 * @date 2021/2/26 11:32 下午
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode node = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int pop = stack1.isEmpty() ? 0 : stack1.pop();
            int pop1 = stack2.isEmpty() ? 0 : stack2.pop();
            int add = pop + pop1 + carry;
            carry = add / 10;
            add = add % 10;
            ListNode newNode = new ListNode(add);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }
}
