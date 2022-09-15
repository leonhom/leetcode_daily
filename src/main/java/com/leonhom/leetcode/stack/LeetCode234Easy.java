package com.leonhom.leetcode.stack;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: leon wang
 * @since: 2022/09/08
 */
public class LeetCode234Easy {

    @Test
    public void test() {

    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> valList = new ArrayList<>();
        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }

        int front = 0;
        int end = valList.size() - 1;
        while (front < end) {
            if (!valList.get(front).equals(valList.get(end))) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
}
