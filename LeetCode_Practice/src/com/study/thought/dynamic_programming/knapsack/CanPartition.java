package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description 分割等和子集
 * @Author Yin
 * @Date 2020/6/7 15:56
 * @Version 1.0
 **/
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {1, 5,11,5};
        System.out.println(canPartition_better(nums));
    }

    public static boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum%2!=0){
            return false;
        }
        int target = sum / 2;
        boolean[][] f = new boolean[nums.length+1][target+1];
        for (int i = 0; i <= nums.length; i++) {
            f[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i-1]; j <= target; j++) {
                f[i][j] = f[i-1][j] || f[i-1][j-nums[i-1]];
            }
        }
        return f[nums.length][target];
    }

    public static boolean canPartition_better(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum / 2;
        boolean[] f = new boolean[target+1];
        f[0] = true; // 保证每次放入的值和target相等时为true
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                f[i] = f[i] || f[i-num];
            }
        }
        return f[target];
    }
}
