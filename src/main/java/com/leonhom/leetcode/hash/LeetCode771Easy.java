package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: leon WANG
 * @since: 2023/03/27
 */
public class LeetCode771Easy {

    @Test
    public void test() {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneMap = new HashMap<>();
        for (char c : stones.toCharArray()) {
            stoneMap.put(c, stoneMap.getOrDefault(c, 0) + 1);
        }

        int result = 0;

        for (char c : jewels.toCharArray()) {
            result += stoneMap.getOrDefault(c, 0);
        }

        return result;
    }
}
