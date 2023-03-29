package com.leonhom.leetcode.hash;

import org.junit.Test;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望下标数字 i 和 j 满足 i < j 且有(time[i] + time[j]) % 60 == 0。
 *
 * 示例 1：
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 *
 * 示例 2：
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 *
 * @author: leon WANG
 * @since: 2023/03/28
 */
public class LeetCode1010Medium {

    @Test
    public void test() {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));
    }

    public int numPairsDivisibleBy60(int[] time) {

        // 统计每个余数值（0-59）出现的个数。
        int[] seconds = new int[60];
        int res = 0;
        // 遍历time数组，每个值对60取模，并统计每个余数值（0-59）出现的个数。
        for (int t : time) {
            // i 代表当前数被60整除缺的数值
            int i = 60 - t % 60;

            // {30, 20, 150, 100, 40};
            // 累计符合条件的组合数。注意一定要先累计，再添加。这样做的正确性很好理解：第一次遇到一个余数时，是无法凑成歌曲对的。
            // 以后每次遇到一个特定余数时，都能和所有对应余数的歌曲形成新的歌曲对。这也是为什么，res要累计当前所有对应余数的歌曲数量。
            // 获取数组中，需要的数值对应的数字的数量
            res += seconds[i == 60 ? 0 : i];
            // 将当前数的余数放入数组中
            seconds[t % 60] += 1;
        }
        return res;
    }

}
