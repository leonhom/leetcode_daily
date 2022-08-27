package com.leonhom.leetcode.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 难度：easy
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：输入：s = "()"， 输出：true
 * 示例 2：输入：s = "()[]{}"，输出：true
 * 示例 3：输入：s = "(]"，输出：false
 * 示例 4：输入：s = "([)]"， 输出：false
 * 示例 5：输入：s = "{[]}"，输出：true
 *
 * @author leon
 * @date 2022/3/20
 */
public class LeetCode20 {

    @Test
    public void test() {
        // String s = "()";
        // String s = "()[]{}";
        // String s = "(]";
        // String s = "([)]";
        // String s = "){";
        String s = "))";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char tmpC = s.charAt(i);
            if (map.containsKey(tmpC)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(tmpC))) {
                    return false;
                }
            } else {
                stack.push(tmpC);
            }
        }
        return stack.isEmpty();
    }
}
