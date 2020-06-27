package com.study.thought.math;

import static java.lang.Integer.MAX_VALUE;

/**
 * @Description 是否是三的幂
 * @Author Yin
 * @Date 2020/6/10 21:01
 * @Version 1.0
 **/
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(Math.log(MAX_VALUE)/Math.log(3));
        int res = (int) Math.pow(3, (int)(Math.log(MAX_VALUE)/Math.log(3)));
        System.out.println(res);
    }
    public boolean isPowerOfThree(int n) {
        return n>0 && (1162261467%n == 0);   // 1162261467 =(int) Math.pow(3, (int)(Math.log(MAX_VALUE)/Math.log(3)))
    }
}
