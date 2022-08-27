package com.leonhom.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例1:
 * 输入：s = "abaccdeff", 输出：'b'
 * 示例 2:
 * 输入：s = "",  输出：' '
 *
 * @author leon
 * @date 2022/3/14
 */
public class Interview50 {

    @Test
    public void test() {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
