package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
 * 请你返回words数组中一致字符串 的数目。
 *
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 * @author: leon wang
 * @since: 2023/03/01
 */
public class LeetCode1684Easy {

    @Test
    public void test() {

        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};

        System.out.println(countConsistentStrings(allowed, words));

    }

    public int countConsistentStrings(String allowed, String[] words) {

        Map<Character, Character> keyMap = new HashMap<>();

        for (char c : allowed.toCharArray()) {
            keyMap.putIfAbsent(c, c);
        }

        int resultCount = 0;

        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (keyMap.get(c) == null) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                resultCount++;
            }
        }

        return resultCount;
    }
}
