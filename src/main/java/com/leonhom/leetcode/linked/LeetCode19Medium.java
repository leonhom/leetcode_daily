package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author: leon
 * @date: 2022/05/07
 */
public class LeetCode19Medium {

    @Test
    public void test() {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        return null;

    }

    public ListNode doublePoint(ListNode head, int n) {
        ListNode tempNode = new ListNode(0, head);
        ListNode fastNode = head;
        ListNode slowNode = tempNode;

        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;
        return tempNode.next;
    }

    public ListNode countSize(ListNode head, int n) {
        return null;
    }



}
