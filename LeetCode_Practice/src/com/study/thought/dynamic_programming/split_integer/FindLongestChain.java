package com.study.thought.dynamic_programming.split_integer;

import java.util.Arrays;

/**
 * @Description 最长数对链
 * @Author Yin
 * @Date 2020/6/6 21:10
 * @Version 1.0
 **/
public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = {
                {3,4},
                {1,2},
                {2,3},
        };
        System.out.println(findLongestChain(pairs));
    }
    public static int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0||pairs[0].length==0){
            return 0;
        }
        if(pairs.length==1){
            return 1;
        }
        // 排序
        Arrays.sort(pairs,(o1, o2) -> o1[0] - o2[0]);
        int[] f = new int[pairs.length];
        f[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i-1; j >= 0; j--) {
                if(pairs[i][0] > pairs[j][1]){
                    max = Math.max(f[j],max);
                }
            }
            if(max == Integer.MIN_VALUE){
                f[i] = 1;
            }else{
                f[i] = max+1;
            }
        }

        int res = f[0];
        for (int len : f) {
            res = Math.max(len,res);
        }

        return res;
    }
}
