package com.leonhom.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leon
 * @date 2022/3/25
 */
public class LeetCode1117Medium {

    private AtomicInteger state = new AtomicInteger(2);

    public void printH() {
        while (state.get() == 0) {
            Thread.yield();
        }
        System.out.print("H");
        state.decrementAndGet();
    }

    public void printO() {
        while (state.get() != 0) {
            Thread.yield();
        }
        System.out.println("O");
        state.set(2);
    }

    public static void main(String[] args) {

    }
}
