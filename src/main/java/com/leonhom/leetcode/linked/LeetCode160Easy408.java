package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 *
 * @408 2012年算法设计原题
 * @author: leon wang
 * @since: 2022/09/13
 */
public class LeetCode160Easy408 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Map<ListNode, Integer> counter = new HashMap<>();

        ListNode listA = headA.next;
        ListNode listB = headB.next;
        while (listA == null && listB == null) {

            if (counter.containsKey(listA)) {
                return listA;
            } else if (counter.containsKey(listB)) {
                return listB;
            }

            if (listA != null) {
                counter.put(listA, counter.getOrDefault(listA, 0) + 1);
                listA = listA.next;
            }

            if (listB != null) {
                counter.put(listB, counter.getOrDefault(listB, 0) + 1);
                listB = listB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
