package com.study.structure.bitwise_operation;

/**
 * @Description 数组中不重复的两个元素
 * @Author Yin
 * @Date 2020/6/25 16:15
 * @Version 1.0
 **/
public class SingleNumber_III {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff; //得到最右一位
        int[] res = new int[2];
        for (int num : nums) {
            if((diff&num) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
