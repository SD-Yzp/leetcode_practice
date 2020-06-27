package com.study.structure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 数组的度
 * @Author Yin
 * @Date 2020/6/14 20:22
 * @Version 1.0
 **/
public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findShortestSubArray(nums));
    }
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> firstMap = new HashMap<>();
        Map<Integer,Integer> lastMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!firstMap.containsKey(nums[i])){
                firstMap.put(nums[i],i);
            }else{
                lastMap.put(nums[i],i);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // 如果数组中所有的数只出现一次
        if(lastMap.isEmpty()){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            max = Math.max(value,max);
        }
        for (int num : nums) {
            if(map.get(num)==max){
                minLen = Math.min(lastMap.get(num)-firstMap.get(num)+1,minLen);
            }
        }
        return minLen;
    }
}
