package com.study.structure.array;

import java.util.Arrays;

/**
 * @Description 优美的排列 II
 * @Author Yin
 * @Date 2020/6/14 18:43
 * @Version 1.0
 **/
public class ConstructArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(6,5)));
    }
    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int temp1 = n;  // 尾部值
        int temp2 = 0;  // 顺序值
        for (int i = 0; i < n; i++) {
            if(n-i==k && k > 1){
                res[i] = temp1;
                temp1--;
                temp2--;
                k -= 2;
            }else{
                res[i] = i+1+temp2;
            }
        }
        return res;
    }
}
