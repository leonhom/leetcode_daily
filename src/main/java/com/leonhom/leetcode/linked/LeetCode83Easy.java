package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次 。返回已排序的链表。
 *
 * 示例1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * @author: leon
 * @Date: 2022/05/03
 */
public class LeetCode83Easy {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                // 删除current节点
                current.next = current.next.next;
            } else {
                // 遍历后移
                current = current.next;
            }
        }
        return head;
    }
}
