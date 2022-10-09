package com.leonhom.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 856. 括号的分数
 *
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * @author: leon wang
 * @since: 2022/10/09
 */
public class LeetCode856Medium {

    @Test
    public void test() {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public int scoreOfParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 入栈，用0代替左括号
                stack.push(0);
                continue;
            }

            // 计算分数
            int base = 0;
            while (!stack.isEmpty() && stack.peek() != 0) {
                base += stack.pop();
            }
            // 去掉左括号
            stack.pop();
            // base=0表示直接找到左括号, ()直接入栈1, 否则得到(A)得2 * A分
            stack.push(base == 0 ? 1 : 2 * base);
        }

        // 累加结果
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
