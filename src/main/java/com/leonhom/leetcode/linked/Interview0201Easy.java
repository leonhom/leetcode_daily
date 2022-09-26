package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: leon wang
 * @since: 2022/09/25
 */
public class Interview0201Easy {

    @Test
    public void test() {

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> tempSet = new HashSet<>();
        tempSet.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode curr = pos.next;
            if (tempSet.add(curr.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }
}
