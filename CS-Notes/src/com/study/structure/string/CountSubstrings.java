package com.study.structure.string;

/**
 * @Description 回文子串
 * @Author Yin
 * @Date 2020/6/17 20:29
 * @Version 1.0
 **/
public class CountSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(isPalindrome(s.substring(i,j+1))){
                    res++;
                }
            }
        }
        return res;
    }


    private static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private int count = 0;

    /**
     * 马车算法，从中心扩张
     * @param s
     * @return
     */
    public int countSubStrings_better(String s){
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s,i,i);        //奇数长度
            extendSubstrings(s,i,i+1);  // 偶数长度
        }
        return count;
    }

    private void extendSubstrings(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }


}
