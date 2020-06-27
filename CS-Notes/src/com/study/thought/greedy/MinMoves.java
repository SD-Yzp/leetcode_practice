package com.study.thought.greedy;

/**
 * @Description 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 * @Author Yin
 * @Date 2020/5/29 21:09
 * @Version 1.0
 **/
public class MinMoves {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minMoves_Math(nums));
    }
    public static int minMoves(int[] nums) {
        int res = 0;
        int d;
        do{
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(nums[i],min);
                if(nums[i]>max){
                    max = nums[i];
                    index = i;
                }
            }
            d = max - min;
            if(d>0){
                for (int i = 0; i < nums.length; i++) {
                    if(i==index){
                        continue;
                    }
                    nums[i] += d;
                }
            }
            res += d;
        }while(d>0);

        return res;
    }

    public static int minMoves_Math(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num,min);
        }
        for (int num : nums) {
            res += num - min;
        }

        return res;
    }
}
