package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 *
 * @author: leon wang
 * @since: 2023/02/28
 */
public class LeetCode2325Easy {

    @Test
    public void test() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key, message));
    }

    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> keyMap = new HashMap<>();
        char temp = 'a';

        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (keyMap.putIfAbsent(c, temp) == null) {
                temp++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append(" ");
                continue;
            }
            stringBuilder.append(keyMap.get(c));
        }
        return stringBuilder.toString();
    }
}
