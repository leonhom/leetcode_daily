package com.leonhom.leetcode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. 根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1: 输入: "tree"; 输出: "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * @author leon
 * @date 2022/3/3
 */
public class LC451 {

    @Test
    public void test() {
        String temp = "tree";
        System.out.println(frequencySort(temp));
    }

    public String frequencySort(String s) {

        Map<Character, Integer> tempMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] tempArray = new ArrayList[s.length() + 1];
        for (Character c : tempMap.keySet()) {
            Integer value = tempMap.get(c);
            if (tempArray[value] == null) {
                tempArray[value] = new ArrayList<>();
            }
            tempArray[value].add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = tempArray.length - 1; i > 0; i--) {
            List<Character> tempList = tempArray[i];
            if (tempList != null && tempList.size() > 0) {
                for (Character character : tempList) {
                    for (int j = 0; j < i; j++) {
                        sb.append(character);
                    }
                }
            }
        }

        return sb.toString();
    }
}
