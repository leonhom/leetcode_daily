package com.leonhom.leetcode.linked;

import com.leonhom.leetcode.linked.entity.ListNode;

import java.time.chrono.HijrahDate;

/**
 * 1265. 逆序打印不可变链表
 *
 * 给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
 * ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
 * 您需要使用以下函数来访问此链表（您不能直接访问ImmutableListNode）：
 * ImmutableListNode.printValue()：打印当前节点的值。
 * ImmutableListNode.getNext()：返回下一个节点。
 * 输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [0,-4,-1,3,-5]
 * 输出：[-5,3,-1,-4,0]
 *
 * 示例 3：
 * 输入：head = [-2,0,6,4,4,-6]
 * 输出：[-6,4,4,6,0,-2]
 *
 * @author: leon wang
 * @since: 2022/09/15
 */
public class LeetCode1265Medium {

    public void printLinkedListInReverse(ListNode head) {
        if (head != null) {
            printLinkedListInReverse(head.next);
            printValue();
        }
    }

    private void printValue() {

    }
}
