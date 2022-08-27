package com.leonhom.leetcode.common.utils;

/**
 * @author: leon
 * @date: 2022/05/08
 */
public class CommonUtil {
    
    /**
     * 打印int数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    /**
     * 交换数值
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swapIntArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
