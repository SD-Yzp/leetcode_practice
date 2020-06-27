package com.study.structure.array;

/**
 * @Description 最大连续1的个数
 * @Author Yin
 * @Date 2020/6/13 15:28
 * @Version 1.0
 **/
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int temp = 0;
        for (int num : nums) {
            if(num==1){
                temp++;
            }else{
                res = Math.max(temp,res);
                temp=0;
            }
        }
        res = Math.max(temp,res);  // 可能最后一个也是1
        return res;
    }
}
