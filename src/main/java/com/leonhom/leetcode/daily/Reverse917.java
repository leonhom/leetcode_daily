package com.leonhom.leetcode.daily;

public class Reverse917 {

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (true) {

            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }

            if (left >= right) {
                break;
            }

            // 保证当前都是字母，进行交换
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // 交换之后，指针移动
            left++;
            right--;
        }

        System.out.println(new String(chars));

    }
}
