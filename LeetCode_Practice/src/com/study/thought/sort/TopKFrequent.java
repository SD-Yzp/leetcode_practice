package com.study.thought.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @Author Yin
 * @Date 2020/5/29 16:54
 * @Version 1.0
 **/
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,3,3};
        int[] res = topKFrequent_Priority(nums, 2);
        System.out.println(Arrays.toString(res));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        int[] count = new int[map.size()];
        int index = 0;
        for (Integer value : map.values()) {
            count[index++] = value;
        }

        Arrays.sort(count);

        for (int i = 0; i < k; i++) {
            for (Integer key : map.keySet()) {
                if(map.get(key)==count[index-1]){
                    res[i] = key;
                    map.remove(key);
                    --index;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 使用队列解决
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent_Priority(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        for (Integer key : map.keySet()) {
            queue.offer(key);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int index = 0;
        for (Integer value : queue) {
            res[index++] = value;
        }

        return res;
    }
}
