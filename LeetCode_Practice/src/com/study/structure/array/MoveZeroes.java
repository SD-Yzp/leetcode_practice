package com.study.structure.array;

import java.util.Arrays;

/**
 * @Description 移动0
 * @Author Yin
 * @Date 2020/6/12 22:44
 * @Version 1.0
 **/
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums){
        int index = 0;
        for (int num : nums) {
            if(num!=0){
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[index++] = 0;
        }
    }
}
