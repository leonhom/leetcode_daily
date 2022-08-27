package com.leonhom.leetcode;

import org.junit.Test;

public class Offer24 {

    private static ListNode nodeTest = new ListNode(1);

    static {
        nodeTest.next = new ListNode(2);
        nodeTest.next.next = new ListNode(3);
        nodeTest.next.next.next = new ListNode(4);
        nodeTest.next.next.next.next = new ListNode(5);
    }

    @Test
    public void reverseList() {
        ListNode current = nodeTest;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        printNodeVal(prev);
    }

    public void printNodeVal(ListNode node) {
        ListNode tempNode = node;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
