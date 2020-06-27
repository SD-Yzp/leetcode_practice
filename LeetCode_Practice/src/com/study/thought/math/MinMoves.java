package com.study.thought.math;

import java.util.Arrays;

/**
 * @Description 改变数组元素使所有的数组元素都相等
 * @Author Yin
 * @Date 2020/6/8 21:11
 * @Version 1.0
 **/
public class MinMoves {
    public static void main(String[] args) {
        int[] nums = {1,2,100};
        System.out.println(minMoves2_better(nums));
    }
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            moves += nums[r] - nums[l];
            l++;
            r--;
        }
        return moves;
    }

    public static int minMoves2_better(int[] nums){
        int move = 0;
        int median = findKthSmallest(nums,nums.length/2);
        for (int num : nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private static int findKthSmallest(int[] nums, int k) {
        int l = 0;
        int h = nums.length-1;
        while (l < h){
            int j = partition(nums,l,h);
            if(j==k){
                break;
            }
            if(j<k){
                l = j+1;
            }else {
                h = j-1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l;
        int j = h+1;
        while(true){
            while(nums[++i] < nums[l] && i < h);
            while(nums[--j] > nums[l] && j > l);
            if(i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
