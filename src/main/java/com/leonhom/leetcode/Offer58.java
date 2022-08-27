package com.leonhom.leetcode;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 *  示例 1：
 *      输入: s = "abcdefg", k = 2
 *      输出: "cdefgab"
 */
public class Offer58 {
    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        // String preStr = s.substring(0, k);
        // String lastStr = s.substring(k, s.length());
        // System.out.println(lastStr + preStr);
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            int index = i % s.length();
            res.append(s.charAt(index));
        }

        System.out.println(res.toString());

    }
}
