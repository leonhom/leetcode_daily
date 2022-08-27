package com.leonhom.leetcode.doublepointer;

import org.junit.Test;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @author leon
 * @date 2022/02/25
 */
public class LC88 {

    @Test
    public void test() {
        int[] nums1 = {0}, nums2 = {6};
        int m = 0, n = 1;
        merge(nums1, m, nums2, n);
    }

    /**
     * 双指针，从数组末尾开始遍历，将符合要求的元素直接添加至数组末尾
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 定义左右指针
        int p1 = m - 1;
        int p2 = n - 1;

        // 定义索引插入起始位置
        int index = m + n - 1, temp;

        while (p1 > -1 || p2 > -1) {
            if (p1 == -1) {
                // nums1元素已经遍历完，直接将nums2的元素添加即可
                temp = nums2[p2--];
            } else if (p2 == -1) {
                // nums2元素已经遍历完，直接将nums1的元素添加即可
                temp = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                // 比较两数大小，将大值插入
                temp = nums1[p1--];
            } else {
                temp = nums2[p2--];
            }
            nums1[index--] = temp;
        }
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
