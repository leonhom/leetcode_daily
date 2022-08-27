package com.leonhom.leetcode;

import org.junit.Test;

public class Offer17 {

    private static int n = 3;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] num = new char[n];

    public static void main(String[] args) {
        concat(0);
        System.out.println(stringBuilder.toString());
    }

    public static void concat(int index) {
        if (index == n) {
            // 当前末位数已确定，取出数值保存
            stringBuilder.append(new String(num)).append(",");
            // 返回上层递归
            return;
        }

        for (char c : loop) {
            num[index] = c;
            concat(index + 1);
        }

    }

    @Test
    public void test() {
        int i = 0;
        while (n > 0) {
            // System.out.println(i++);
            if (String.valueOf(i).length() > n) {
                return;
            }
        }
    }
}

