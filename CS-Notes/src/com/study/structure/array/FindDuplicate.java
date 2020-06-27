package com.study.structure.array;

/**
 * @Description 寻找重复数
 * @Author Yin
 * @Date 2020/6/14 10:33
 * @Version 1.0
 **/
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4};
        System.out.println(findDuplicate(nums));
    }
    /**
     * 要求:
     *  空间:O(1) 时间:O(n^2) 不能改变原数组
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            int count = 0;
            for (int num : nums) {
                if(i==num){
                    count++;
                    if(count==2){
                        return i;
                    }
                }
            }
        }
        return -1;  // 如果存在重复元素，不会到达这里
    }
}
