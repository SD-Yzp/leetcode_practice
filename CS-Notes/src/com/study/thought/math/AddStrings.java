package com.study.thought.math;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/8 19:31
 * @Version 1.0
 **/
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("923","345"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;
        while(carry==1 || index1>=0 || index2>=0){
            if(index1>=0){
                // System.out.println(num1.charAt(index1));
                carry += num1.charAt(index1--)-'0';
            }
            // System.out.println(carry);
            if(index2>=0){
                carry += num2.charAt(index2--)-'0';
            }
            sb.append(carry%10);
            carry /= 10;
        }

        return sb.reverse().toString();
    }
}
