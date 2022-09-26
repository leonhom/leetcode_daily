package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1836. 从未排序的链表中移除重复元素
 *
 * 给定一个链表的第一个节点 head ，找到链表中所有出现多于一次的元素，并删除这些元素所在的节点。
 * 返回删除后的链表。
 *
 * 示例 1:
 * 输入: head = [2,1,1,2]
 * 输出: []
 * 解释: 2 和 1 都出现了两次。所有元素都需要被删除。
 *
 * 示例 2:
 * 输入: head = [3,2,2,1,3,2,4]
 * 输出: [1,4]
 * 解释: 3 出现了两次，且 2 出现了三次。移除了所有的 3 和 2 后，我们还剩下 [1,4] 。
 *
 * @author: leon wang
 * @since: 2022/09/25
 */
public class LeetCode1836Medium {

    @Test
    public void test() {

    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> tempMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            tempMap.put(temp.val, tempMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr != null && curr.next != null) {
            if (tempMap.get(curr.next.val) > 1) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummyHead.next;
    }
}
