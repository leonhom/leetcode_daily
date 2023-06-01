package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给你一个整数数组nums。如果任一值在数组中出现至少两次，返回true；
 * 如果数组中每个元素互不相同，返回false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * @author leon
 * @date 2022/3/18
 */
public class LeetCode217Easy {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        // int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
