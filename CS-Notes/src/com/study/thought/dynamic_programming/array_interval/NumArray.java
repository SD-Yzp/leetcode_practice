package com.study.thought.dynamic_programming.array_interval;

public class NumArray {
    private int[] nums;
    private int[] sums;



    public NumArray(int[] nums) {
        this.nums = nums;
        if(nums==null||nums.length==0){
            sums = new int[]{0};
        }else{
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(nums==null||nums.length==0){
            return 0;
        }
        return sums[j] - sums[i] + nums[i];
    }

    public static void main(String[] args) {
        // int[] nums = {-2, 0, 3, -5, 2, -1};
        int[] nums = {};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,0));
    //     System.out.println(numArray.sumRange(0,2));
    //     System.out.println(numArray.sumRange(2,5));
    //     System.out.println(numArray.sumRange(0,5));
    }
}