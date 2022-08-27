package com.leonhom.leetcode.doublepointer;

import org.junit.Test;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾
 * 连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false
 *
 * @author leon
 * @date 2022/02/25
 */
public class LC141 {

    @Test
    public void test() {

    }

    /**
     * 双指针龟兔赛跑算法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode pSlow = head;
        ListNode pFast = head.next;

        while (pSlow != pFast) {
            if (pFast.next == null || pFast == null) {
                return false;
            }
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}


