package com.study.thought.dynamic_programming.split_integer;

/**
 * @Description 最长上升子序列
 * @Author Yin
 * @Date 2020/6/6 19:58
 * @Version 1.0
 **/
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] f = new int[nums.length];
        int res = Integer.MIN_VALUE;
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i-1; j >= 0; j--) {
                if(nums[j]<nums[i]){
                    max = Math.max(f[j],max);
                }
            }
            // 判断是否当前值为最小值
            if(max != Integer.MIN_VALUE){
                f[i] = max + 1;
            }else{
                f[i] = 1;
            }
        }

        for (int len : f) {
            res = Math.max(len,res);
        }
        return res;
    }

    public int lengthOfLIS_binarySearch(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
