package com.study.thought.math;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/7 20:34
 * @Version 1.0
 **/
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTile(27));
    }
    public static String convertToTile(int num){
        StringBuilder sb = new StringBuilder();
        while (num>0){
            num--;
            sb.append((char)(num%26+'A'));
            num /= 26;
        }
        return sb.reverse().toString();
    }
}
