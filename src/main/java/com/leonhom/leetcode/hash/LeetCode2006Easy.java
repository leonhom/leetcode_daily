package com.leonhom.leetcode.hash;

import org.junit.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组nums和一个整数k，请你返回数对(i, j)的数目，满足i < j且|nums[i] - nums[j]| == k。
 *
 * |x|的值定义为：
 * 如果x >= 0，那么值为x。
 * 如果x < 0，那么值为-x。
 *
 * 示例 1：
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 *
 * 示例 2：
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 *
 * 示例 3：
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 * @author: leon WANG
 * @since: 2023/03/28
 */
public class LeetCode2006Easy {

    @Test
    public void test() {
        int[] nums = {1, 2, 2, 1};
        int k = 1;
        System.out.println(countKDifference(nums, k));
    }

    public int countKDifference(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            result += numMap.getOrDefault(num - k, 0) + numMap.getOrDefault(num + k, 0);
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
