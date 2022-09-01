package com.leonhom.leetcode.array;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author leon
 * @date 2022/3/31
 */
public class LeetCode977Easy {

    @Test
    public void test() {
        int[] nums = {-4, -1, 0, 3, 10};
        CommonUtil.printArr(sortedSquares(nums));
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        // 左指针
        int left = 0;
        // 右指针
        int right = nums.length - 1;
        // 新数组插入坐标值
        int pos = nums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 将i放入数组末尾
                result[pos] = nums[left] * nums[left];
                ++left;
            } else {
                result[pos] = nums[right] * nums[right];
                --right;
            }
            --pos;
        }
        return result;

    }
}
