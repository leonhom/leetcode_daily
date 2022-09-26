package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 *
 * @author: leon wang
 * @since: 2022/09/25
 */
public class Interview0206Easy {

    @Test
    public void test() {

    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            array.add(head.val);
            curr = curr.next;
        }

        int first = 0, last = array.size() - 1;
        while (first < last) {
            if (!array.get(first).equals(array.get(last))) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
