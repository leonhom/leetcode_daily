package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 *
 * 给你一个下标从 0开始长度为 n的字符串num，它只包含数字。
 * 如果对于 每个0 <= i < n的下标i，都满足数位i在 num中出现了num[i]次，那么请你返回true，否则返回false。
 *
 * 示例 1：
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回true。
 *
 * 示例 2：
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了两次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false。
 *
 * @author: leon WANG
 * @since: 2023/07/05
 */
public class LeetCode2283Easy {

    @Test
    public void test() {
        String str = "1210";
        System.out.println(digitCount(str));
    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for (char c : num.toCharArray()) {
            int temp = Integer.parseInt(String.valueOf(c));
            newMap.put(temp, newMap.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < num.toCharArray().length; i++) {
            int temp = Integer.parseInt(String.valueOf(num.charAt(i)));
            Integer orDefault = newMap.getOrDefault(i, 0);
            if (temp!=orDefault) {
                return false;
            }
        }
        return true;
    }
}
