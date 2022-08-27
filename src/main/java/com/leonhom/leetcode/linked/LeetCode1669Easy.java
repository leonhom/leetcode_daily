package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 1669. 合并两个链表
 *
 * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 * 请你将list1中下标从 a 到 b 的全部节点都删除，并将list2接在被删除节点的位置。
 *
 * 示例 1：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 * 示例 2：
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 * @author: leon
 * @date: 2022/05/06
 */
public class LeetCode1669Easy {

    @Test
    public void test() {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // List2的尾节点
        ListNode list2Last = list2;
        while (list2Last.next != null) {
            list2Last = list2Last.next;
        }

        ListNode head = list1;
        ListNode pre = null;
        ListNode last = null;
        int index = 0;
        while (head != null) {
            if (index == a - 1) {
                pre = head;
            } else if (index == b) {
                last = head.next;
                break;
            }
            index++;
            head = head.next;
        }

        pre.next = list2;
        list2Last.next = last;

        return list1;
    }
}
