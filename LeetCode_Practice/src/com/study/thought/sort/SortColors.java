package com.study.thought.sort;

import java.util.Arrays;

/**
 * @Description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *              此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Author Yin
 * @Date 2020/5/29 18:05
 * @Version 1.0
 **/
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int p = 0;
        while(p<=end){
            if(nums[p]==0){
                swap(nums,start,p);
                p++;
                start++;
            }else if(nums[p]==2){
                swap(nums,end,p);
                end--;
            }else {
                p++;
            }
        }
    }

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
