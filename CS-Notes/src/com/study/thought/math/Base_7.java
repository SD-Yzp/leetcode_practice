package com.study.thought.math;

/**
 * @Description 七进制
 * @Author Yin
 * @Date 2020/6/7 19:56
 * @Version 1.0
 **/
public class Base_7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
    public static String convertToBase7(int num){
        if(num==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        if(isNegative){
            num = -num;
        }
        while(num > 0){
           sb.append(num%7);
           num /= 7;
        }
        if(isNegative){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
