package com.study.thought.math;

/**
 * @Description 计算素数
 * @Author Yin
 * @Date 2020/6/7 19:37
 * @Version 1.0
 **/
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(7));
    }
    public static int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int res = 1;
        for (int i = 3; i < n; i+=2) {
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }
    private static boolean isPrime(int num){
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end ; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
