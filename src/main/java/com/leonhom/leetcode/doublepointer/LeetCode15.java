package com.leonhom.leetcode.doublepointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为0且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输入：nums = [-4,-1,-1,0,1,2]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 测试用例:[-2,0,0,2,2]
 * 期望结果:[[-2,0,2]]
 *
 * @author leon
 * @date 2022/3/18
 */
public class LeetCode15 {

    @Test
    public void test() {
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 0, 2, 2};

        System.out.println(threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] > 0) {
                break;
            }
            // 跳过相同元素
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int target = -nums[index];
            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int tempNum = nums[leftIndex] + nums[rightIndex];
                if (tempNum < target) {
                    leftIndex++;
                } else if (tempNum > target) {
                    rightIndex--;
                } else {
                    resultList.add(Arrays.asList(nums[index], nums[leftIndex], nums[rightIndex]));
                    leftIndex++;
                    rightIndex--;
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }
                }
            }
        }
        return resultList;
    }

}
