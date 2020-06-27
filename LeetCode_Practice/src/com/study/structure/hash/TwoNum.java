package com.study.structure.hash;

import java.util.*;

/**
 * @Description 两个数
 * @Author Yin
 * @Date 2020/6/12 16:35
 * @Version 1.0
 **/
public class TwoNum {
    public static void main(String[] args) {
        int[] nums = {2, 7,10,3, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums,14)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);

            }
            map.put(nums[i],i);
        }
        return res;
    }
}
