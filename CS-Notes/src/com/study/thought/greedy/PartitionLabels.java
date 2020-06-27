package com.study.thought.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 划分字母区间
 * @Author Yin
 * @Date 2020/5/31 16:40
 * @Version 1.0
 **/
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "qiejxqfnqceocmy";
        List<Integer> res = partitionLabels(s);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
    public static List<Integer> partitionLabels(String S) {
        if(S==null||S.length()==0){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        // 预处理，找到每个字母的最后一个位置
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i),i);
        }

        int start = 0;
        int end = 0;
        while(end < S.length()-1){
            char c1 = S.charAt(start);
            int temp1 = map.get(c1);
            int max = temp1;
            for (int i = start+1; i < temp1; i++) {
                // 获得区间内字母最后出现的位置
                int temp2 = map.get(S.charAt(i));
                if(temp2 > max){
                    max = temp2;
                    // 遍历的区间需要改变
                    temp1 = temp2;
                }
            }
            end = max;
            res.add(end-start+1);
            start = end+1;
        }

        return res;
    }
}
