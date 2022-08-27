package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * @author: leon
 * @date: 2022/05/08
 */
public class LeetCode82Medium {

    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.setNextNode(2).setNextNode(3).setNextNode(3).setNextNode(4).setNextNode(4).setNextNode(5);
        deleteDuplicates(head);

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode tempNode = new ListNode(-1, head);

        ListNode current = tempNode;

        while (current.next != null && current.next.next != null) {
            // 当前结点的后两个结点是否相等
            if (current.next.val == current.next.next.val) {
                // 取下一个结点的val值
                int tempVal = current.next.val;
                // 依次删除后面的结点
                while (current.next != null && current.next.val == tempVal) {
                    // 删除当前结点的下一个结点
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return tempNode.next;
    }
}
