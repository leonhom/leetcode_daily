package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: leon WANG
 * @since: 2023/04/10
 */
public class LeetCode2418Easy {

    @Test
    public void test() {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        for (String s : sortPeople(names, heights)) {
            System.out.println(s);
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            nameMap.put(names[i], heights[i]);
        }

        Arrays.sort(names, (n1, n2) -> Integer.compare(nameMap.get(n2), nameMap.get(n1)));

        return names;
    }
}
