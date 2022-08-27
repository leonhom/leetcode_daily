package com.leonhom.leetcode.doublepointer;

public class LC167 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int left = numbers[leftIndex];
            int right = numbers[rightIndex];
            if (left + right == target) {
                System.out.println(leftIndex + 1);
                System.out.println(rightIndex + 1);
                break;
                // return new int[]{left + 1, right + 1};
            }
            if (left + right > target) {
                rightIndex--;
            } else if (left + right < target) {
                leftIndex++;
            }
        }
    }
}
