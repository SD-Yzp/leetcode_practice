package com.study.thought.greedy;

/**
 * @Description 判断子序列
 * @Author Yin
 * @Date 2020/5/30 18:09
 * @Version 1.0
 **/
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        int len1 = s.length();
        int len2 = t.length();
        while(p1<len1&&p2<len2){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
            }
            p2++;
        }

        return p1==len1;
    }
}
