package com.leonhom.leetcode.string;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author leon
 * @date 2022/3/20
 */
public class LeetCode14 {

    @Test
    public void test() {
        // String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longesCommonPrefix(strs));
    }

    public String longesCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            int preLen = preStr.length();
            int tmpLen = temp.length();
            int len = preLen < tmpLen ? preLen : tmpLen;
            int index = 0;
            while (index < len && preStr.charAt(index) == temp.charAt(index)) {
                index++;
            }
            preStr = preStr.substring(0, index);
        }
        return preStr;
    }
}
