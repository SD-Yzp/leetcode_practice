package com.study.thought.greedy;

import java.util.Arrays;

/**
 * @Description 投飞镖刺破气球
 * @Author Yin
 * @Date 2020/5/30 15:09
 * @Version 1.0
 **/
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0){
            return 0;
        }
        int res = 1;
        Arrays.sort(points,(o1, o2) -> o1[1]-o2[1]);    // 按照结尾大小升序
        int end = points[0][1]; // 记录第一个结束位置
        for (int i = 1; i < points.length; i++) {
            // 不重叠,需要多一支箭
            if(points[i][0]>end){
                res++;
                end = points[i][1];
            }
        }

        return res;
    }
}
