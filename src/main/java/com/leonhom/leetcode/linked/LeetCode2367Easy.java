package com.leonhom.leetcode.linked;

import org.junit.Test;

/**
 * @author: leon wang
 * @since: 2022/09/15
 */
public class LeetCode2367Easy {

    @Test
    public void test() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println(arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int left = 0, right = 1;
        int count = 0;
        while (left < nums.length && right < nums.length) {
            int l = nums[left];
            int r = nums[right];

            if (r - l == diff) {
                count++;
                right++;
            } else {
                right++;
            }

            if (right == nums.length) {
                right = ++left + 1;
            }
        }
        return count;
    }
}
