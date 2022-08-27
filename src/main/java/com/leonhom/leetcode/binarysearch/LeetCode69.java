package com.leonhom.leetcode.binarysearch;

import org.junit.Test;

/**
 * 69. x 的平方根
 *
 * 给你一个非负整数x ，计算并返回x的算术平方根 。
 * 由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2： 输入：x = 8， 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * @author leon
 * @date 2022/3/4
 */
public class LeetCode69 {

    @Test
    public void test() {
        System.out.println(mySqrt(5));
    }

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
