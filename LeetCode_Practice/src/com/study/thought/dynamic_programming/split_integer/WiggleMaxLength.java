package com.study.thought.dynamic_programming.split_integer;

/**
 * @Description 最大摆动子序列
 * @Author Yin
 * @Date 2020/6/6 22:04
 * @Version 1.0
 **/
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int up=1;
        int down=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                up = down + 1;
            }else if(nums[i]<nums[i-1]){
                down = up +1;
            }
        }
        return Math.max(up,down);
    }
}
