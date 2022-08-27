package com.leonhom.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1: 输入：s = "egg", t = "add" 输出：true
 * 示例 2：输入：s = "foo", t = "bar" 输出：false
 * 示例 3：输入：s = "paper", t = "title", 输出：true
 *
 * @author leon
 * @date 2022/3/9
 */
public class LeetCode205 {

    @Test
    public void test() {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (map1.containsKey(cs) && map1.get(cs) != ct) {
                return false;
            }

            if (map2.containsKey(ct) && map2.get(ct) != cs) {
                return false;
            }

            map1.put(cs, ct);
            map2.put(ct, cs);
        }

        return true;

    }

}
