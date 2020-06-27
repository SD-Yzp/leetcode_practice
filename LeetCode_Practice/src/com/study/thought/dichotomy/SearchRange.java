package com.study.thought.dichotomy;

import java.util.Arrays;

/**
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @Author Yin
 * @Date 2020/6/1 14:54
 * @Version 1.0
 **/
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,7)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        int last = findFirst(nums,target+1)-1;
        if(nums.length==first||nums[first]!=target){
            return new int[]{-1,-1};
        }else{
            return new int[]{first,last};
        }
    }

    private static int findFirst(int[] nums,int target){
        int l = 0;
        int r = nums.length;  // 可能不存在
        int mid;
        while(l < r){
            mid = l + (r - l)/2;
            if(target <= nums[mid]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
