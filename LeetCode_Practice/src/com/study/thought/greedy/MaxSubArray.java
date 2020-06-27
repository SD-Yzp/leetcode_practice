package com.study.thought.greedy;

/**
 * @Description 最大子序和
 * @Author Yin
 * @Date 2020/5/31 15:18
 * @Version 1.0
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] nums = {-2,-1};
        System.out.println(maxSubArray_II(nums));
    }

    public static int maxSubArray_I(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int res = f[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            res = Math.max(res,f[i]);
        }

        return res;
    }

    public static int maxSubArray_II(int[] nums) {
        int res = nums[0];
        int sum = -1;
        for (int num : nums) {
            if(sum < 0){
                sum = num;
            }else {
                sum += num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
