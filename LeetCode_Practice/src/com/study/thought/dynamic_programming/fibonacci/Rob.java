package com.study.thought.dynamic_programming.fibonacci;

/**
 * @Description 强盗抢劫
 * @Author Yin
 * @Date 2020/6/5 16:04
 * @Version 1.0
 **/
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums){
        int a = 0, b = 0;
        for (int num : nums) {
            // 转移方程 f(n) = max(f(n-2)+nums[i],f(n-1))
            int temp = Math.max(a + num, b);
            a = b;
            b = temp;
        }
        return b;
    }
}
