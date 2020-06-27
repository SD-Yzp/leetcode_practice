package com.study.thought.dichotomy;

/**
 * @Description 实现sqrt函数
 * @Author Yin
 * @Date 2020/5/31 17:07
 * @Version 1.0
 **/
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt_II(5));
    }

    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int res = (int) Math.exp(0.5*Math.log(x));

        return (long)(res+1)*(res+1) <= x ? res+1:res;
    }

    public static int mySqrt_II(int x) {
        if(x==0||x==1){
            return x;
        }
        int left = 1;
        int right = x;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;   // 因为left+right可能存在越界问题，而right-left不会
            // long temp =  mid * mid;  计算阶段数据就会溢出，所以赋给temp的不是long的，而是int的
            if((long) mid * mid==x){
                return mid;
            }else if((long) mid * mid>x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }


}
