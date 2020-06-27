package com.study.structure.string;

/**
 * @Description 字符串同构
 * @Author Yin
 * @Date 2020/6/17 17:03
 * @Version 1.0
 **/
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if(preIndexOfS[sc]!=preIndexOfT[st]){
                return false;
            }
            preIndexOfS[sc] = i+1;
            preIndexOfT[st] = i+1;
        }
        return true;
    }
}
