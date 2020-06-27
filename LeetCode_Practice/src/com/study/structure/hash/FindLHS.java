package com.study.structure.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 最长和谐序列
 * @Author Yin
 * @Date 2020/6/12 18:07
 * @Version 1.0
 **/
public class FindLHS {
    public static void main(String[] args) {
        // int[] nums = {1,3,2,2,5,2,3,7};
        int[] nums = {1,1,1,1};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1); // getOrDefault(Object key, V defaultValue) 能查到key返回查到的，查不到返回defaultValue
        }

        int max = 0;
        for (int num : nums) {
            if(map.containsKey(num+1)){
                max = Math.max(map.get(num)+map.get(num+1),max);
            }
        }
        return max;
    }
}
