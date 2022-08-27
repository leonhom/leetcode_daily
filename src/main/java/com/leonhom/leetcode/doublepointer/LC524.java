package com.leonhom.leetcode.doublepointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * <p>
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * @author leon
 * @date 2022/02/25
 */
public class LC524 {

    @Test
    public void test() {

        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");

        System.out.println(findLongestWord(s, dictionary));

    }

    /**
     * 双指针匹配
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String resutl = "";
        for (String s1 : dictionary) {
            int sIndex = 0;
            int s1Index = 0;
            while (sIndex < s.length() && s1Index < s1.length()) {
                if (s.charAt(sIndex) == s1.charAt(s1Index)) {
                    s1Index++;
                }
                sIndex++;

                if (s1Index == s1.length()) {
                    // 字典遍历到头，找到匹配字符串
                    if (resutl.length() < s1.length() || (resutl.length() == s1.length() && s1.compareTo(resutl) < 0)) {
                        resutl = s1;
                    }
                }
            }

        }
        return resutl;
    }

    /**
     * 双指针+排序
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord2(String s, List<String> dictionary) {
        String result = "";
        Collections.sort(dictionary, new Comparator<String>() {
            // 先按字符串长度降序，再按字符升序
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    // 升序
                    return o1.compareTo(o2);
                }
            }
        });

        for (String s1 : dictionary) {
            int strIndex = 0;
            int s1Index = 0;
            while (strIndex < s.length() && s1Index < s1.length()) {
                if (s.charAt(strIndex) == s1.charAt(s1Index)) {
                    s1Index++;
                }
                strIndex++;

                if (s1Index == s1.length()) {
                    if (result.length()<s1.length()) {
                        result = s1;
                    }
                }
            }
        }

        return result;
    }

}
