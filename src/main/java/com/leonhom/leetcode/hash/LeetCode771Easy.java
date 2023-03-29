package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 *
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 *
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
