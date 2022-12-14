package com.leonhom.leetcode.string;

import org.junit.Test;

/**
 * 9. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：输入：x = 121，输出：true
 * 示例 2：输入：x = -121，输出：false，解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：输入：x = 10，输出：false，解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author leon
 * @date 2022/3/9
 */
public class LeetCode9 {

    @Test
    public void test() {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }

        if (revertNumber == x || revertNumber / 10 == x) {
            return true;
        }

        return false;

    }

}
