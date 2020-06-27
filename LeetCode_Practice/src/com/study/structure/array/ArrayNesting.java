package com.study.structure.array;

import java.util.*;

/**
 * @Description 嵌套数组
 * @Author Yin
 * @Date 2020/6/15 15:20
 * @Version 1.0
 **/
public class ArrayNesting {
    public static void main(String[] args) {
        // int[] nums = {5,4,0,3,1,6,2};
        int[] nums = {0};
        System.out.println(arrayNesting(nums));
    }
    public static int arrayNesting(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();  // 存放以key开头的嵌套数组长度
        Set<Integer> set = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int temp = num;
            int temp_len = 0;
            while(set.add(temp)){
                queue.add(temp);
                temp = nums[temp];
                // 如果下边的数已经被计算过，那么直接弹出
                if(map.containsKey(temp)){
                    temp_len = map.get(temp);
                    break;
                }
            }
            // 将以这个数开头没有用到的数放入map中，提高效率
            while (!queue.isEmpty()){
                map.put(queue.poll(),queue.size()+1+temp_len);
            }
            max = Math.max(set.size(),max);
            set.clear();
        }
        return max;
    }



    public static int arrayNesting_better(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; nums[j]!=-1 ;) {
                count++;
                int temp = nums[j];
                nums[j] = -1; // 标记该位置
                j = temp;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
