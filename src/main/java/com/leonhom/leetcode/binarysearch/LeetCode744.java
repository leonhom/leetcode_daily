package com.leonhom.leetcode.binarysearch;

import org.junit.Test;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 *
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 *
 * 示例 3:
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 *
 * @author leon
 * @date 2022/3/4
 */
public class LeetCode744 {

    @Test
    public void test() {
        char[] chars = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(chars, 'c'));
        // System.out.println(nextGreatestLetter2(chars, 'd'));
    }

    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0;
        int r = letters.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (r < 0 || l > letters.length) {
            return letters[0];
        }

        return letters[l];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
