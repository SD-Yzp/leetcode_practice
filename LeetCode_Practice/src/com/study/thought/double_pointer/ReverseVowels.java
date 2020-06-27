package com.study.thought.double_pointer;

/**
 * @Description 反转
 * @Author Yin
 * @Date 2020/5/28 15:56
 * @Version 1.0
 **/
public class ReverseVowels {
    public static void main(String[] args){
        System.out.println(reverseVowels("Aa"));
    }


    public static String reverseVowels(String s) {
        // 转成字符数组
        char[] chars = s.toCharArray();
        // 双指针
        int start = 0;
        int end = chars.length-1;
        // 相交结束
        while(start<end){
            while(start<end&&!isVowels(chars[start])){
                start++;
            }
            while(start<end&&!isVowels(chars[end])){
                end--;
            }
            // 交换位置
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            // 改变指针位置
            start++;
            end--;
        }

        return new String(chars);
    }

    private static boolean isVowels(char c){
        switch (c) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'u':
            case 'U':
            case 'o':
            case 'O':
            case 'i':
            case 'I':
                return true;
            default:
                return false;
        }
    }
}
