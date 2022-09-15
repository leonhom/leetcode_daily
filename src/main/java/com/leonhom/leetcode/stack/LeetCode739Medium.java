package com.leonhom.leetcode.stack;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @author: leon wang
 * @since: 2022/09/08
 */
public class LeetCode739Medium {

    @Test
    public void test() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        CommonUtil.printArr(dailyTemperatures(temperatures));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        // temperatures = [73,74,75,71,69,72,76,73]
        // answer = [1,1,4,2,1,1,0,0]
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        return answer;
    }
}
