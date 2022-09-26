package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 * 示例1
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * 示例2
 * 输入: head = [1,2]
 * 输出: false
 *
 * @author: leon wang
 * @since: 2022/09/25
 */
public class OfferII27Easy {

    @Test
    public void test() {

    }

    /**
     * 时间复杂度O(n) * O(n/2)，总复杂度O(2n)=O(n)
     * 空间复杂度O(n)，n为链表的元素个数
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> array = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            array.add(current.val);
            current = current.next;
        }

        int first = 0, last = array.size() - 1;
        while (first < last) {
            if (array.get(first).equals(array.get(last))) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * TODO 2022/09/25 快慢指针实现待补充
     *
     * @param node
     * @return
     */
    public boolean isPalindrome1(ListNode node) {
        return false;
    }

}
