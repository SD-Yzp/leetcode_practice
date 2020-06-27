package com.study.structure.bitwise_operation;

/**
 * @Description 找到数组中缺失的数
 * @Author Yin
 * @Date 2020/6/25 15:40
 * @Version 1.0
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res ^= (i+1) ^ nums[i];
        }
        return res;
    }
    // 高斯
    public int missingNumber_Gauss(int[] nums) {
        int n = nums.length;
        int sum = (n+1)*n/2;
        int actual_sum = 0;
        for (int i = 0; i < n; i++) {
            actual_sum += nums[i];
        }
        return sum - actual_sum;
    }
}
