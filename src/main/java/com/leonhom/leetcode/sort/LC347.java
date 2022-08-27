package com.leonhom.leetcode.sort;

import com.leonhom.common.utils.CommonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1: 输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2]
 * 示例 2: 输入: nums = [1], k = 1 输出: [1]
 *
 * @author leon
 * @date 2022/3/3
 */
public class LC347 {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        CommonUtil.printArr(topKFrequent(nums, k));
    }


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // 将元素放入map，key：元素值，value：出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 将所有元素，按大小倒叙，插入到list数组中
        List[] arrayLists = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (arrayLists[value] == null) {
                arrayLists[value] = new ArrayList();
            }
            arrayLists[value].add(key);
        }

        // 遍历List数组，取出对应的值
        List<Integer> resultTemp = new ArrayList<>();
        for (int i = arrayLists.length - 1; i > 0 && resultTemp.size() < k; i--) {
            List tempList = arrayLists[i];
            if (tempList != null) {
                if (tempList.size() <= (k - resultTemp.size())) {
                    resultTemp.addAll(tempList);
                } else {
                    resultTemp.addAll(tempList.subList(0, k - resultTemp.size()));
                }
            }
        }

        int[] resultArray = new int[k];

        for (int i = 0; i < k; i++) {
            resultArray[i] = resultTemp.get(i);
        }

        return resultArray;
    }
}
