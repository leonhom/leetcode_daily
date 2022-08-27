package com.leonhom.leetcode.doublepointer;

/**
 * 题目描述：判断一个非负整数是否为两个整数的平方和。
 */
public class LC633 {
    public static void main(String[] args) {
        int target = 2147483600;

        /**
         * 双指针思想
         * 1. 左指针从0开始
         * 2. 设右指针为x；0² + x² = target²；解得x = target开根号；
         * 3. 移动指针进行计算，若计算值小于目标值target，左指针+1；
         * 4. 若计算值大于目标值target，右指针-1；
         * 5，循环往复，知道找到目标值
         */
        int leftIndex = 0;
        int rightIndex = (int) Math.sqrt(target);

        while (leftIndex <= rightIndex) {
            int sumTemp = leftIndex * leftIndex + rightIndex * rightIndex;
            if (sumTemp < target) {
                leftIndex++;
            } else if (sumTemp > target) {
                rightIndex--;
            } else {
                System.out.println(leftIndex + "," + rightIndex);
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
