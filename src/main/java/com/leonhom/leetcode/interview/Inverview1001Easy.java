package com.leonhom.leetcode.interview;

import com.leonhom.leetcode.common.utils.CommonUtil;
import org.junit.Test;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * 给定两个排序后的数组A和B，其中A的末端有足够的缓冲空间容纳B。 编写一个方法，将B合并入A并排序。
 * 初始化A和B的元素数量分别为m和n。
 *
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * @author leon
 * @date 2022/3/31
 */
public class Inverview1001Easy {

    @Test
    public void test() {
        int[] a = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] b = {2, 5, 6};
        int n = 3;
        merge(a, m, b, n);
        CommonUtil.printArr(a);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int aLast = m - 1;
        int bLast = n - 1;
        int tailIndex = m + n - 1;
        int tempNum;
        while (aLast >= 0 || bLast >= 0) {
            if (aLast == -1) {
                // a指针已经到头，直接取b的值
                tempNum = B[bLast--];
            } else if (bLast == -1) {
                tempNum = A[aLast--];
            } else if (A[aLast] > B[bLast]) {
                tempNum = A[aLast--];
            } else {
                tempNum = B[bLast--];
            }
            A[tailIndex--] = tempNum;
        }
    }
}
