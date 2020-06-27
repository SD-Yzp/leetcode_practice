package com.study.structure.string;

/**
 * @Description 回文数  要求不转成字符串
 * @Author Yin
 * @Date 2020/6/17 21:16
 * @Version 1.0
 **/
public class NumIsPalindrome {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x < 0 || x % 10 == 0){
            return false;
        }
        int right = 0;
        while(x > right){
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}
