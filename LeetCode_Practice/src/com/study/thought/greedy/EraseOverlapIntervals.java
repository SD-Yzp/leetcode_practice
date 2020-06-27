package com.study.thought.greedy;

import java.util.Arrays;

/**
 * @Description 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * @Author Yin
 * @Date 2020/5/29 22:06
 * @Version 1.0
 **/
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                /*{1,2},
                {1,2}*/
                /*{2,3},
                {3,4},
                {1,3}*/
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }
        int res = 0;
        Arrays.sort(intervals,(o1, o2) -> o1[1] - o2[1]);
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i+1][0]<end){
                res++;
            }else {
                end = intervals[i+1][1];
            }
        }
        return res;
    }
}
