package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false。
 *
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 *
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 *
 * @author: leon wang
 * @since: 2023/03/01
 */
public class LeetCode1832Easy {

    @Test
    public void test() {
        String sentence = "leetcode";
        System.out.println(checkIfPangram(sentence));
    }

    public boolean checkIfPangram(String sentence) {
        Map<Character, Character> keyMap = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            keyMap.put(i, i);
        }

        for (char c : sentence.toCharArray()) {
            keyMap.remove(c);
        }

        if (keyMap.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
