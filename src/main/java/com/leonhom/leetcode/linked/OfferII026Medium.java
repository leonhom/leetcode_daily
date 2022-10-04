package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例1
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 *
 * 示例2
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 *
 * @408 2015原题
 * @author: leon wang
 * @since: 2022/09/20
 */
public class OfferII026Medium {

    @Test
    public void test() {

    }

    /**
     * O(N)
     * O(N)
     *
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        List<ListNode> arrNode = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            arrNode.add(node);
            node = node.next;
        }

        int i = 0, j = arrNode.size() - 1;
        while (i < j) {
            arrNode.get(i).next = arrNode.get(j);
            i++;
            if (i == j) {
                break;
            }
            arrNode.get(j).next = arrNode.get(i);
            j--;
        }
        arrNode.get(i).next = null;
    }

    public void reorderList1(ListNode head) {

    }
}
