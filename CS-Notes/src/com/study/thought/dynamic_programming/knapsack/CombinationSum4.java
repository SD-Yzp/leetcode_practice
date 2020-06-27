package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description 组合求和4
 * @Author Yin
 * @Date 2020/6/8 16:53
 * @Version 1.0
 **/
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
    public static int combinationSum4(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] f = new int[target+1];
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {      //  实际这里可以让f[0]=1,这样就不需要判断i==num的情况，直接归为一类，即i>=num
                if(i==num){
                    f[i] += 1;
                }else if(i > num && f[i-num]!=0){
                    f[i] += f[i-num];
                }
            }
        }
        return f[target];
    }
}
