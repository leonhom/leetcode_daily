package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author: leon
 * @date: 2022/06/07
 */
public class LeetCode3Medium {

    @Test
    public void test() {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int rk = -1, ans = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                // 窗口移动，移除Set中重复的字符
                set.remove(s.charAt(i - 1));
            }
            // 左指针后移
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                // 将当前字符添加到哈希表中
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 说明左指针出现重复字符; 当前指针位置 - 起始位置 + 1 = 长度
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;

    }
}
