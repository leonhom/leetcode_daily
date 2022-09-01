package com.leonhom.leetcode.sort;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

/**
 * 75. 颜色分类【荷兰国旗问题】
 *
 * 给定一个包含红色、白色和蓝色、共n个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 进阶：
 * 1. 你可以不使用代码库中的排序函数来解决这道题吗？
 * 2. 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author leon
 * @date 2022/3/3
 */
public class LC75 {

    @Test
    public void test() {
        int[] arr = {2, 0, 1};
        sortColors3(arr);
        CommonUtil.printArr(arr);
    }

    /**
     * 单指针
     *
     * 1. 第一遍先把0归位
     * 2. 第二遍把1归位
     * 2. 0和1都归位后，2必然也都归位了
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                CommonUtil.swapIntArray(nums, ptr, i);
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                CommonUtil.swapIntArray(nums, ptr, i);
                ptr++;
            }
        }
    }

    /**
     * 双指针从左往右
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                CommonUtil.swapIntArray(nums, p1, i);
                p1++;
            } else if (num == 0) {
                CommonUtil.swapIntArray(nums, p0, i);
                if (p0 < p1) {
                    CommonUtil.swapIntArray(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    /**
     * 双指针，从两边往中间
     *
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int rightIndex = nums.length - 1;
        int i = 0;
        int leftIndex = 0;
        while (i <= rightIndex) {
            if (nums[i] == 0) {
                CommonUtil.swapIntArray(nums, leftIndex, i);
                leftIndex++;
                i++;
            } else if (nums[i] == 2) {
                CommonUtil.swapIntArray(nums, rightIndex, i);
                rightIndex--;
            } else {
                i++;
            }
        }

    }
}
