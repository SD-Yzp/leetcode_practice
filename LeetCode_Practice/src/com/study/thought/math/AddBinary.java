package com.study.thought.math;

/**
 * @Description 二进制相加
 * @Author Yin
 * @Date 2020/6/8 17:23
 * @Version 1.0
 **/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("111","111"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index1 = a.length()-1;
        int index2 = b.length()-1;
        int carry = 0;  // 进位标志
        while(index1 >= 0 || index2 >= 0 || carry == 1){
            if(index1>=0 && a.charAt(index1--)=='1'){
                carry++;
            }
            if(index2>=0 && b.charAt(index2--)=='1'){
                carry++;
            }
            sb.append(carry%2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
