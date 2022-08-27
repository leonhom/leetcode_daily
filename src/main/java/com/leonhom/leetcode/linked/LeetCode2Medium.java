package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 *
 * 示例 2：输入：l1 = [0], l2 = [0] 输出：[0]
 *
 * 示例 3：输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 *
 * @author leon
 * @date 2022/3/22
 */
public class LeetCode2Medium {

    @Test
    public void test() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        addTwoNumbers(node1, node4);
        // System.out.println(getNodeNumber(node1));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO 2022/03/22 LeetCode2.两数相加【待完成】
        int l1Number = getNodeNumber(l1);
        int l2Number = getNodeNumber(l2);
        return numberToNode(l1Number + l2Number);
    }

    public int getNodeNumber(ListNode node) {
        if (node.next == null) {
            return node.val;
        }
        return node.val + getNodeNumber(node.next) * 10;
    }

    public ListNode numberToNode(int nodeNumber) {
        if (nodeNumber == 0) {
            return new ListNode(0, null);
        }

        String nodeStr = String.valueOf(nodeNumber);


        ListNode resultNode = new ListNode(-1);
        ListNode tempNode = resultNode;

        for (int i = nodeStr.length() - 1; i >= 0; i--) {
            char c = nodeStr.charAt(i);
            int i1 = Integer.parseInt(String.valueOf(c));
            System.out.println(i1);
            tempNode.next = new ListNode(i1);
            tempNode = tempNode.next;
        }


        // while (nodeNumber != 0) {
        //     int temp = nodeNumber % 10;
        //     tempNode.next = new ListNode(temp);
        //     tempNode = tempNode.next;
        //     nodeNumber /= 10;
        // }

        return resultNode.next;
    }

}
