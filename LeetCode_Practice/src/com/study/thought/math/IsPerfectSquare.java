package com.study.thought.math;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/10 20:48
 * @Version 1.0
 **/
public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare_better(16));
    }
    public static boolean isPerfectSquare(int num) {
        // 题目要求是输入正整数
        if(num <= 0){
            return false;
        }
        long standard = 1;
        long N = 2;
        while(standard <= num){
            if(num == standard){
                return true;
            }else{
                standard += N+1 ;
                N += 2;
            }
        }
        return false;
    }
    public static boolean isPerfectSquare_better(int num) {
        int standard = 1;
        while(0 < num){
            num -= standard;
            standard += 2;
        }
        return num==0;
    }
}
