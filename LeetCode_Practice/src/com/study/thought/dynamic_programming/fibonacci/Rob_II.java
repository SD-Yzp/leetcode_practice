package com.study.thought.dynamic_programming.fibonacci;

/**
 * @Description 强盗抢劫
 * @Author Yin
 * @Date 2020/6/5 16:04
 * @Version 1.0
 **/
public class Rob_II {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public static int rob(int[] nums,int start,int end){
        int a = 0, b = 0;
        for (int i = start; i < end; i++) {
            // 转移方程 f(n) = max(f(n-2)+nums[i],f(n-1))
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }

        return b;
    }
}
