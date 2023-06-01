package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: leon WANG
 * @since: 2023/04/10
 */
public class LeetCode1748Easy {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(sumOfUnique(nums));
    }

    public int sumOfUnique(int[] nums) {

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : numMap.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                result += integerIntegerEntry.getKey();
            }
        }

        return result;
    }

    public int sumOfUnique2(int[] nums) {
        int result = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                result += num;
                numMap.put(num, 1);
            } else if (numMap.get(num) == 1) {
                result -= num;
                numMap.put(num, 2);
            }
        }
        return result;
    }
}
