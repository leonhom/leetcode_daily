package com.leonhom.leetcode;

import java.util.Stack;

public class LeetCode0202 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();

        for (int i : array) {
        }
        int temp = stack.size()-2;

        System.out.println(stack.get(temp));
    }
}
