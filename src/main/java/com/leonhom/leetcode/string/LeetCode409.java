package com.leonhom.leetcode.string;

import org.junit.Test;

/**
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 * 示例 1: 输入:s = "abccccdd"，输出:7，解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 示例 2: 输入:s = "a" 输入:1
 *
 * 示例 3: 输入:s = "bb"，输入: 2
 *
 * @author leon
 * @date 2022/3/9
 */
public class LeetCode409 {

    @Test
    public void test() {
        String str = "bb";
        System.out.println(longestPalindrome(str));
    }

    public int longestPalindrome(String s) {
        int[] nums = new int[128];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)]++;
        }


        int length = 0;
        for (int num : nums) {
            length += num / 2 * 2;
            if (length % 2 == 0 && num % 2 == 1) {
                length += 1;
            }
        }

        return length;

    }
}
