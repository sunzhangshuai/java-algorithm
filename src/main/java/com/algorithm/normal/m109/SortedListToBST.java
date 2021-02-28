package com.algorithm.normal.m109;

/**
 * SortedListToBST:有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author sunchen
 * @date 2021/3/1 12:25 上午
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //找中间结点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            pre = fast;
            fast = fast.next.next;
        }
        //退出循环，找到了中间结点
        //中间结点是：
        TreeNode treeNode = new TreeNode();
        ListNode node = pre.next;
        treeNode.val = node.val;
        pre.next = null;
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(node.next);
        return treeNode;
    }
}
