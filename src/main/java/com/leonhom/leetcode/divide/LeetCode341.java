package com.leonhom.leetcode.divide;

import org.junit.Test;

import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2：
 *
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author leon
 * @date 2022/3/4
 */
public class LeetCode341 {

    @Test
    public void test() {
        //TODO 2022/03/09 LeetCode241. 为运算表达式设计优先级【未完成】
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return null;
    }
}
