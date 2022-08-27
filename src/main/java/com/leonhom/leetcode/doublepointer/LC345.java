package com.leonhom.leetcode.doublepointer;

/**
 * 345. 反转字符串中的元音字母
 *
 * @date 2022/02/24
 */
public class LC345 {
    public static void main(String[] args) {
        String s = "leetcode";
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = chars.length - 1;
        while (leftIndex < rightIndex) {
            char left = chars[leftIndex];
            char right = chars[rightIndex];
            if (!isVowel(left)) {
                leftIndex++;
            } else if (!isVowel(right)) {
                rightIndex--;
            } else {
                chars[leftIndex] = right;
                chars[rightIndex] = left;
                rightIndex--;
                leftIndex++;
            }
        }
        System.out.println(new String(chars));
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
