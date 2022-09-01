package com.leonhom.leetcode.stack;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 示例1
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 *
 * 示例2
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 * @author: leon wang
 * @since: 2022/09/01
 */
public class LeetCode496Easy {

    @Test
    public void test() {
        // int[] nums1 = {4, 1, 2};
        // int[] nums2 = {1, 3, 4, 2};
        // int[] nums1 = {2, 4};
        // int[] nums2 = {1, 2, 3, 4};
        int[] nums1 = {3, 1, 5, 7, 9, 2, 6};
        int[] nums2 = {1, 2, 3, 5, 6, 7, 9, 11};
        // [5,2,6,9,11,3,7]
        CommonUtil.printArr(nextGreaterElementOfficial(nums1, nums2));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = nums2.length - 1; j >= 0; j--) {
                stack.push(nums2[j]);
                // 栈不为空，并且栈的第一个元素（来自nums2）小于等于nums1中当前的元素
                while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
                    // 从栈中弹出
                    stack.pop();
                }
                if (nums1[i] == nums2[j]) {
                    // 如果元素相等，则退出判断
                    break;
                }
            }
            // result赋值
            result[i] = stack.isEmpty() ? -1 : stack.peek();
        }
        return result;
    }

    public int[] nextGreaterElementOfficial(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Map<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            hashMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = hashMap.get(nums1[i]);
        }

        return result;
    }
}
