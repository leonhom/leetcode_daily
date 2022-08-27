package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 1474.删除链表 M 个节点之后的 N 个节点
 *
 * 给定链表head和两个整数m和n. 遍历该链表并按照如下方式删除节点:
 *
 * 开始时以头节点作为当前节点.
 * 保留以当前节点开始的前m个节点.
 * 删除接下来的n个节点.
 * 重复步骤 2 和 3,直到到达链表结尾.
 * 在删除了指定结点之后,返回修改过后的链表的头节点.
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
 * 输出: [1,2,6,7,11,12]
 * 解析: 保留前(m = 2)个结点,  也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
 * 删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
 * 继续相同的操作, 直到链表的末尾.
 * 返回删除结点之后的链表的头结点.
 *
 * 示例 2:
 * 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
 * 输出: [1,5,9]
 * 解析: 返回删除结点之后的链表的头结点.
 *
 * 示例 3:
 * 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
 * 输出: [1,2,3,5,6,7,9,10,11]
 *
 * 示例 4:
 * 输入: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
 * 输出: [9,7,8]
 *
 * @author: leon
 * @date: 2022/05/05
 */
public class LeetCode1474Easy {

    @Test
    public void test() {

    }

    public ListNode deleteNodes(ListNode head, int m, int n) {
        // TODO 2022/05/05 方案待优化
        if (head == null) {
            return head;
        }

        ListNode current = head;
        int saveCount = m;
        int deleteCount = n;

        while (current != null) {
            while (current != null && saveCount > 1) {
                current = current.next;
                --saveCount;
            }
            if(current == null) {
                break;
            }
            saveCount = m;
            // 执行删除
            while (current.next != null && deleteCount > 0) {
                current.next = current.next.next;
                --deleteCount;
            }
            current = current.next;
            deleteCount = n;
        }

        return head;
    }

}
