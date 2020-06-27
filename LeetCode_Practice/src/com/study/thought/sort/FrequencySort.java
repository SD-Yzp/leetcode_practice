package com.study.thought.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * @Author Yin
 * @Date 2020/5/29 17:18
 * @Version 1.0
 **/
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }

    public static String frequencySort(String s) {
        if(s==null||s.length()==0){
            return "";
        }

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        // 降序
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));

        for (Character key : map.keySet()) {
            queue.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        /*PriorityQueue：
            1、无界，线程不安全队列
            2、数组实现，拥有优先级的队列   ->   只能保证取出的第一个是最大或者最小的，不能保证整个队列有序
            3、需要指定排序器(对象实现Comparable接口或者创建时指定Comparator比较器)
        */
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
