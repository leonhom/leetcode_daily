package com.leonhom.leetcode.doublepointer;

import com.leonhom.common.utils.CommonUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * 测试用例:[2,1] [1,1]
 * 期望结果:[1]
 *
 * @author leon
 * @date 2022/3/18
 */
public class LeetCode349 {

    @Test
    public void test() {
        int[] nums1 = {2, 1}, nums2 = {1, 1};
        CommonUtil.printArr(intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0, index2 = 0;
        int length1 = nums1.length, length2 = nums2.length;
        // Set<Integer> set = new HashSet<>();
        int[] intersection = new int[length1 + length2];
        int index = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 < num2) {
                index1++;
            } else if (num1 > num2) {
                index2++;
            } else {
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                // set.add(num1);
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
        // return set.stream().mapToInt(i -> i).toArray();
    }

}
