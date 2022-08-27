package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 206. 反转链表
 *
 * @author leon
 * @date 2022/3/21
 */
public class LeetCode206Easy {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode listNode = headInsert(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
        // return stack(head);
    }

    public ListNode stack(ListNode head) {
        Stack<ListNode> nodeStack = new Stack();

        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }

        ListNode resultNode = new ListNode(-1);
        while (!nodeStack.isEmpty()) {
            resultNode.next = nodeStack.pop();
            resultNode = resultNode.next;
        }

        return resultNode.next;
    }

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public ListNode headInsert(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode last = head;
        ListNode curr = head.next;
        ListNode temp;

        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }

        last.next = null;
        return head;
    }

    public ListNode threePoint(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode curNext;
        ListNode newHead = null;
        while (cur != null) {
            curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

        return newHead;
    }

}

