package com.study.structure.bitwise_operation;

/**
 * @Description 数组中只出现一次的元素
 * @Author Yin
 * @Date 2020/6/25 15:37
 * @Version 1.0
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
