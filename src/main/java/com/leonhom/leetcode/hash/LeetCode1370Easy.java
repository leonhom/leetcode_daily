package com.leonhom.leetcode.hash;

import org.junit.Test;

/**
 * 1370. 上升下降字符串
 *
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 *
 * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s中选择字符。
 * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 重复步骤 5，直到你没法从 s中选择字符。
 * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将s中字符重新排序后的 结果字符串 。
 *
 * 示例 1：
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 *
 * 示例 2：
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 *
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 *
 * @author: leon WANG
 * @since: 2023/07/05
 */
public class LeetCode1370Easy {

    @Test
    public void test() {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }

    public String sortString(String s) {

        int[] number = new int[26];
        for (int i = 0; i < s.length(); i++) {
            number[s.charAt(i) - 'a']++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        while (resultBuilder.length() < s.length()) {
            for (int i = 0; i < number.length; i++) {
                if (number[i] != 0) {
                    resultBuilder.append((char) (i + 'a'));
                    number[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (number[i] != 0) {
                    resultBuilder.append((char) (i + 'a'));
                    number[i]--;
                }
            }
        }

        return resultBuilder.toString();
    }

}
