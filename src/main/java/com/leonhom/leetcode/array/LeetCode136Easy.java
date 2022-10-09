package com.leonhom.leetcode.array;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author: leon wang
 * @since: 2022/10/09
 */
public class LeetCode136Easy {

    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
