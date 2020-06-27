package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description 目标和
 * @Author Yin
 * @Date 2020/6/7 18:43
 * @Version 1.0
 **/
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < S || (sum + S)%2 == 1){
            return 0;
        }
        int W = (sum + S) / 2;
        int[] f = new int[W+1];
        f[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                f[i] = f[i] + f[i-num];
            }
        }
        return f[W];
    }
}
