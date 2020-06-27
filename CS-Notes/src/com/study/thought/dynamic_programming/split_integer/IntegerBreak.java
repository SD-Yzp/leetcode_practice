package com.study.thought.dynamic_programming.split_integer;

/**
 * @Description 分割整数得到最大乘积
 * @Author Yin
 * @Date 2020/6/6 15:27
 * @Version 1.0
 **/
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }
    public static int integerBreak(int n) {
        // 将n%3=2,除数为0,1的情况取出
        if(n==2){
            return 1;
        }
        if(n==5){
            return 6;
        }
        // 等于3也是特殊情况
        if(n==3){
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        if(b==0){
            return (int)Math.pow(3,a);
        }else if(b==1){
            return (int)Math.pow(3,a-1)*4;
        }else{
            return (int)Math.pow(3,a)*2;
        }
    }
}
