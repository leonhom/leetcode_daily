package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;
import org.junit.Test;

/**
 * 237. 删除链表中的节点
 *
 * 请编写一个函数，用于删除单链表中某个特定节点。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问要被删除的节点。
 * 题目数据保证需要删除的节点不是末尾节点 。
 *
 * 示例1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 *
 * 示例2：
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 *
 * @author: leon
 * @date: 2022/05/03
 */
public class LeetCode237Easy {

    @Test
    public void test() {

    }

    /**
     * 思路：既然删除不掉自己，就用下一个节点替换自己，然后删掉下一个节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
