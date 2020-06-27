package com.study.thought.dichotomy;

/**
 * @Description 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * @Author Yin
 * @Date 2020/5/31 18:39
 * @Version 1.0
 **/
public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {3,3,4,5,5};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int len = nums.length;
        // 处理边界
        if(nums[len-1]!=nums[len-2]){
            return nums[len-1];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(l<=r){
            mid = l + (r - l)/2;
            // 处理边界后，一定能找到结果
            if(nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1]){
                return nums[mid];
            }else if((mid%2==0&&nums[mid]==nums[mid-1])||(mid%2!=0&&nums[mid]==nums[mid+1])){
                r = mid - 1;
            }else{
                // 往前找
                l = mid + 1;
            }
        }

        return -1;
    }
}
