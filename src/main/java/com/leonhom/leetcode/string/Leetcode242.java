package com.leonhom.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。
 *
 * 注意：若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author leon
 * @date 2022/3/16
 */
public class Leetcode242 {

    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
