package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import lombok.val;

/**
 * 2181. 合并零之间的节点
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 * 返回修改后链表的头节点 head 。
 *
 * 示例 1：
 * 输入：head = [0,3,1,0,4,5,2,0]
 * 输出：[4,11]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：3 + 1 = 4
 * - 标记为红色的节点之和：4 + 5 + 2 = 11
 *
 * 示例 2：
 * 输入：head = [0,1,0,3,0,2,2,0]
 * 输出：[1,3,4]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：1 = 1
 * - 标记为红色的节点之和：3 = 3
 * - 标记为黄色的节点之和：2 + 2 = 4
 *
 * @author: leon wang
 * @since: 2022/10/03
 */
public class LeetCode2181Medium {

    public void test() {

    }

    public ListNode mergeNodes(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        int total = 0;
        while (fast != null) {
            if (total == 0) {
                slow = slow.next;
            }
            if (fast.val != 0) {
                total += fast.val;
            } else {
                slow.val = total;
                total = 0;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head.next;
    }

    public ListNode mergeNodes1(ListNode head) {
        ListNode slow = head, fast = slow.next;
        int sum = 0;
        while (fast != null) {
            if (sum == 0) {
                slow = slow.next;
            }
            if (fast.val == 0) {
                slow.val = sum;
                sum = 0;
            } else {
                sum += fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head.next;
    }
}
