package com.leonhom.leetcode.thread;

/**
 * 1116. 打印零与奇偶数
 * 三个线程调用方法，分别输出01020304050607
 *
 * @author leon
 * @date 2022/3/25
 */
public class LeetCode1116Medium {

    private int n;

    private volatile int state;

    public LeetCode1116Medium(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() {

        for (int i = 0; i < n; i++) {

            while (state != 0) {
                Thread.yield();
            }
            System.out.print(0);
            if (i % 2 == 0) {
                state = 1;
            } else {
                state = 2;
            }
        }


    }

    /**
     * 输出偶数
     *
     * @throws InterruptedException
     */
    public void even() {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            System.out.print(i);
            state = 0;
        }
    }

    /**
     * 输出奇数
     *
     * @throws InterruptedException
     */
    public void odd() {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            System.out.print(i);
            state = 0;
        }
    }

    public static void main(String[] args) {

        LeetCode1116Medium leetCode1116Medium = new LeetCode1116Medium(7);
        new Thread(() -> {
            leetCode1116Medium.zero();
        }, "Thread_001").start();
        new Thread(() -> {
            leetCode1116Medium.odd();
        }, "Thread_002").start();
        new Thread(() -> {
            leetCode1116Medium.even();
        }, "Thread_003").start();

    }
}
