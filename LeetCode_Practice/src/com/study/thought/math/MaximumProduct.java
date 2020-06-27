package com.study.thought.math;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/10 21:24
 * @Version 1.0
 **/
public class MaximumProduct {
    public static void main(String[] args) {
        // int[] nums = {1,2,3,4,5,6};
        int[] nums = {-4,-3,-2,-1,60};
        System.out.println(maximumProduct(nums));
    }
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            int temp;
            if(num > max1){
                max1 = num;
                if(max1 > max2){
                    temp = max1;
                    max1 = max2;
                    max2 = temp;
                    if(max2 > max3){
                        temp = max2;
                        max2 = max3;
                        max3 = temp;
                    }
                }
            }
            if(min1 > num){
                min1 = num;
                if(min2 > min1){
                    temp = min1;
                    min1 = min2;
                    min2 = temp;
                }
            }
        }
        return Math.max(max1 * max2 * max3,min1 * min2 * max3);
    }
}
