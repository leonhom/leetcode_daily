package com.leonhom.leetcode.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. 算术三元组的数目
 *
 * 给你一个下标从 0 开始、严格递增的整数数组 nums 和一个正整数 diff 。
 * 如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 *
 * 示例 1：
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 *
 * @author: leon WANG
 * @since: 2023/03/29
 */
public class LeetCode2367Easy {

    @Test
    public void test() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println(arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            if (numSet.contains(num - diff) && numSet.contains(num + diff)) {
                result++;
            }
            numSet.add(num);
        }
        return result;
    }
}
