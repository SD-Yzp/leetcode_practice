package com.study.structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 最长回文串
 * @Author Yin
 * @Date 2020/6/17 16:19
 * @Version 1.0
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean flag = false;
        int res = 0;
        for (Character c : map.keySet()) {
            if(map.get(c)%2!=0){
                res += map.get(c)-1;
                flag = true;
            }else {
                res += map.get(c);
            }
        }
        return flag ? res+1 : res;
    }
}
