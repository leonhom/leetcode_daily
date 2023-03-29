package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * @author: leon WANG
 * @since: 2023/03/29
 */
public class Offer39Easy {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement1(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        int len = nums.length;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : numsMap.entrySet()) {
            if (integerIntegerEntry.getValue() > len / 2) {
                return integerIntegerEntry.getKey();
            }
        }

        return -1;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
