package com.study.thought.dichotomy;

/**
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。找到其中最小的元素
 * @Author Yin
 * @Date 2020/5/31 19:22
 * @Version 1.0
 **/
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        // 处理边界条件  只有一个数或者第一个就是最小
        if(nums.length==1||nums[0]<nums[len-1]){
            return nums[0];
        }
        int l = 0;
        int r = len-1;
        int mid;
        while(l<=r){
            mid = l + (r - l)/2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            // 处于前半部分 往后走
            if(nums[mid] > nums[len-1]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return nums[l];
    }
}
