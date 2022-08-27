package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 1290. 二进制链表转整数
 *
 * 给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的十进制值。
 *
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * @author: leon
 * @date: 2022/05/05
 */
public class LeetCode1290Easy {

    @Test
    public void test() {

    }

    public int getDecimalValue(ListNode head) {
        // TODO 2022/05/05 待优化
        int size = -1;
        ListNode countNode = head;
        while (countNode != null) {
            size++;
            countNode = countNode.next;
        }

        int resultNumber = 0;

        while (head != null) {
            int tempVal = head.val;
            resultNumber += tempVal * Math.pow(2, size--);
            head = head.next;
        }

        return resultNumber;
    }
}
