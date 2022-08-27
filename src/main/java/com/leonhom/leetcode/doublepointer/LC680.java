package com.leonhom.leetcode.doublepointer;

import org.junit.Test;

/**
 * 680. 验证回文字符串II
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * @author leon
 * @date 2022/02/25
 */
public class LC680 {

    @Test
    public void test() {
        System.out.println(validPalindrome("deeee"));
    }

    /**
     * 1. 定义左右指针，分别对应字符串头和尾
     * 2. 若指针对应的值不同，则判断删除不同元素后的字符串是否为回文，仅需判断一次（题中要求只能删除一个字符）
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char leftChar = s.charAt(low), rightChar = s.charAt(high);
            if (leftChar == rightChar) {
                ++low;
                --high;
            } else {
                // 分别判断[low+1,high]与[low,high-1]是否为回文
                return onceValid(s, low, high - 1) || onceValid(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean onceValid(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char lowChar = s.charAt(i), highChar = s.charAt(j);
            if (lowChar != highChar) {
                return false;
            }
        }
        return true;
    }
}
