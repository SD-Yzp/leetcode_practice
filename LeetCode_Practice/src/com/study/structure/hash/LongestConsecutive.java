package com.study.structure.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 最长连续序列
 * @Author Yin
 * @Date 2020/6/12 22:36
 * @Version 1.0
 **/
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        int temp;
        for (int num : nums) {
            int temp_long = 0;
            if(!set.contains(num-1)){
                temp_long++;
                temp = num+1;
                while(set.contains(temp)){
                    temp_long++;
                    temp++;
                }
                longest = Math.max(temp_long,longest);
            }
        }
        return longest;
    }
}
