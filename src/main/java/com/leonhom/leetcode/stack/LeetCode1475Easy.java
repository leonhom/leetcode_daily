package com.leonhom.leetcode.stack;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1475. 商品折扣后的最终价格
 *
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 *
 * 示例 1：
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 *
 * 示例 3：
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 *
 * @author: leon wang
 * @since: 2022/09/01
 */
public class LeetCode1475Easy {

    @Test
    public void test() {
        // [4,2,4,2,3]
        int[] prices = new int[]{8, 4, 6, 2, 3};
        // [1,2,3,4,5]
        // int[] prices = new int[]{1, 2, 3, 4, 5};
        // [9,0,1,6]
        // int[] prices = new int[]{10, 1, 1, 6};
        CommonUtil.printArr(finalPricesLeetCode(prices));
    }

    public int[] finalPrices(int[] prices) {
        int index = 0;
        int[] result = new int[prices.length];
        while (index < prices.length) {
            int tempPrice = prices[index];
            int nextIndex = index + 1;
            int compareIndex = nextIndex;
            Stack<Integer> tempStack = new Stack();
            while (nextIndex < prices.length) {
                int nextPrice = prices[nextIndex];
                if (tempStack.isEmpty()) {
                    if (nextPrice <= tempPrice) {
                        tempStack.push(prices[nextIndex]);
                    }
                } else {
                    if (nextPrice <= tempStack.peek() && nextIndex < compareIndex) {
                        tempStack.push(prices[nextIndex]);
                        break;
                    }
                }
                nextIndex++;
            }
            if (tempStack.isEmpty()) {
                result[index] = tempPrice;
            } else {
                result[index] = tempPrice - tempStack.peek();
            }
            index++;
        }
        return result;
    }

    public int[] finalPricesLeetCode(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        // Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
