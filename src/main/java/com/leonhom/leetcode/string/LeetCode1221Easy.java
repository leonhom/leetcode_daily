package com.leonhom.leetcode.string;

import org.junit.Test;

/**
 * 1221. 分割平衡字符串
 * 难度：easy
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"，输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 示例 2：
 * 输入：s = "RLLLLRRRLR"，输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 示例 3：
 * 输入：s = "LLLLRRRR"，输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *
 * 示例 4：
 * 输入：s = "RLRRRLLRLL"，输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * @author leon
 * @date 2022/3/21
 */
public class LeetCode1221Easy {

    @Test
    public void test() {
        String s = "RLRRLLRLRL";
        System.out.println(balanceStringSplit(s));
    }

    public int balanceStringSplit(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }
}
