package com.study.thought.dynamic_programming.split_integer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 按平方数来分割整数
 * @Author Yin
 * @Date 2020/6/6 18:22
 * @Version 1.0
 **/
public class NumSquares {
    public static int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer square : squareList) {
                if(square>i){
                    break;
                }
                min = Math.min(min,f[i-square]+1);
            }
            f[i] = min;
        }
        return f[n];
    }

    private static List<Integer> generateSquareList(int n){
        List<Integer> squareList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if(i*i<n){
                squareList.add(i*i);
            }else{
                break;
            }
        }
        return squareList;
    }
}
