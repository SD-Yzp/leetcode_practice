package com.study.structure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 错误的集合
 * @Author Yin
 * @Date 2020/6/13 23:05
 * @Version 1.0
 **/
public class FindErrorNums {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                res[0] = num;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if(set.add(i)){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
