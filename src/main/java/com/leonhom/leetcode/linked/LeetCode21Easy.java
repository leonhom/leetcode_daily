package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;

/**
 * 21. 合并两个有序链表
 * 难度：easy
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * @author leon
 * @date 2022/3/21
 */
public class LeetCode21Easy {

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (list1.next != null && list2.next != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1.next == null ? list2 : list1;

        return preHead.next;
    }
}