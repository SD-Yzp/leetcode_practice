package com.study.thought.math;

/**
 * @Description 十六进制
 * @Author Yin
 * @Date 2020/6/7 20:06
 * @Version 1.0
 **/
public class ToHex {
    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
    public static String toHex(int num){
        if(num==0){
            return "0";
        }
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(chars[num & 0b1111]);
            num >>>= 4; // 无符号右移四位
        }
        return sb.reverse().toString();
    }
}
