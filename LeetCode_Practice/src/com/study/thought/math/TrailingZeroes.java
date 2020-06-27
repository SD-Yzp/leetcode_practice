package com.study.thought.math;

/**
 * @Description 统计阶乘尾部有多少个0
 * @Author Yin
 * @Date 2020/6/8 17:08
 * @Version 1.0
 **/
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5+trailingZeroes(n/5);
    }

    public static int trailingZeroes_mine(int n) {
        int sum = 0;
        while(n!=0){
            sum += n/5;
            n /= 5;
        }
        return sum;
    }
}
