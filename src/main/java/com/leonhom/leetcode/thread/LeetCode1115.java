package com.leonhom.leetcode.thread;

/**
 * 1115. 交替打印 FooBar
 *
 * 给你一个类：
 *
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 *
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * 两个不同的线程将会共用一个FooBar实例：
 *
 * 线程 A 将会调用 foo() 方法，而线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 示例 2：
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 *
 * @author leon
 * @date 2022/3/19
 */
public class LeetCode1115 {
    //TODO 2022/03/19 LeetCode1115.交替打印FooBar【待完成】
}

class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                System.out.print("foo");
                // printFoo.run();
                this.notify();
                this.wait();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                // printBar.run();
                System.out.print("bar");
                this.notify();
                this.wait();
            }
        }
    }
}
