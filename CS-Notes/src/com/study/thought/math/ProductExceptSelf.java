package com.study.thought.math;

import java.util.Arrays;

/**
 * @Description 乘积数组
 * @Author Yin
 * @Date 2020/6/12 16:17
 * @Version 1.0
 **/
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf_better(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1;
        right[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i-1]*left[i-1];
            right[i] = nums[len-i]*right[i-1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i]*right[len-i-1];
        }
        return res;
    }

    public static int[] productExceptSelf_better(int[] nums) {
        if(nums==null||nums.length==0){
            return nums;
        }
        int len = nums.length;
        int[] res = new int[len];
        int right = 1;
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        for (int i = len-1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

}
