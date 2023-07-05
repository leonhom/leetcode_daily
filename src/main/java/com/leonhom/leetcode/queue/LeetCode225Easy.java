// package com.leonhom.leetcode.queue;
//
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.concurrent.LinkedBlockingQueue;
//
// /**
//  * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//  *
//  * 实现 MyStack 类：
//  * void push(int x) 将元素 x 压入栈顶。
//  * int pop() 移除并返回栈顶元素。
//  * int top() 返回栈顶元素。
//  * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
//  *
//  * 注意：
//  * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
//  * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
//  *
//  * 示例：
//  * 输入：
//  * ["MyStack", "push", "push", "top", "pop", "empty"]
//  * [[], [1], [2], [], [], []]
//  * 输出：
//  * [null, null, null, 2, 2, false]
//  *
//  * 解释：
//  * MyStack myStack = new MyStack();
//  * myStack.push(1);
//  * myStack.push(2);
//  * myStack.top(); // 返回 2
//  * myStack.pop(); // 返回 2
//  * myStack.empty(); // 返回 False
//  *
//  * @author: leon WANG
//  * @since: 2023/06/07
//  */
// public class LeetCode225Easy {
//
// }
//
// class MyStack {
//
//     private Queue<Integer> queue1;
//
//     private Queue<Integer> queue2;
//
//     public MyStack() {
//         queue1 = new LinkedList<>();
//         queue2 = new LinkedList<>();
//     }
//
//     /**
//      * 将元素 x 压入栈顶。
//      *
//      * @param x
//      */
//     public void push(int x) {
//         queue1.add(x);
//     }
//
//     public int pop() {
//
//     }
//
//     public int top() {
//
//     }
//
//     public boolean empty() {
//         return queue1.isEmpty() && queue2.isEmpty();
//     }
// }
//
// /**
//  * Your MyStack object will be instantiated and called as such:
//  * MyStack obj = new MyStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * boolean param_4 = obj.empty();
//  */
