package com.study.thought.dynamic_programming.fibonacci;

/**
 * @Description 爬楼梯
 * @Author Yin
 * @Date 2020/6/5 15:44
 * @Version 1.0
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            b = a;
            a = res;
        }
        return res;
    }
}
