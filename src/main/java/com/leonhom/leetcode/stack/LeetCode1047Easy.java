package com.leonhom.leetcode.stack;

import org.junit.Test;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * @author: leon wang
 * @since: 2022/09/08
 */
public class LeetCode1047Easy {

    @Test
    public void test() {
        System.out.println(removeDuplicates1("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == (stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder build = new StringBuilder();
        while (!stack.isEmpty()) {
            build.append(stack.pop());
        }
        return build.toString();
    }

    public String removeDuplicates1(String str) {
        // a b b a c a
        char[] s = str.toCharArray();
        int top = -1;
        for (int i = 0; i < str.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }
}
