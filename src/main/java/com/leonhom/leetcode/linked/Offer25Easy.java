package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author: leon wang
 * @since: 2022/09/22
 */
public class Offer25Easy {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode newList = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }
        newList.next = l1 == null ? l2 : l1;
        return result.next;
    }

}
