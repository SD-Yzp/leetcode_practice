package com.study.structure.string;

/**
 * @Description 计数二进制子串
 * @Author Yin
 * @Date 2020/6/17 21:20
 * @Version 1.0
 **/
public class CountBinarySubstrings {
    public static void main(String[] args) {
        // String s = "00110011";
        String s = "10101";
        System.out.println(countBinarySubstrings_better(s));
    }
    private static int count = 0;
    public static int countBinarySubstrings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if(i+1 < s.length() && s.charAt(i)!=s.charAt(i+1)){
                extendBinarySubString(s,i,i+1);
            }
        }
        return count;
    }

    private static void extendBinarySubString(String s, int l, int r) {
        do{
            count++;
            l--;
            r++;
        }while(l>=0 && r<s.length() && s.charAt(r-1)==s.charAt(r) && s.charAt(l+1)==s.charAt(l));
    }

    public static int countBinarySubstrings_better(String s){
        int preLen = 0;
        int curLen = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                curLen++;
            }else {
                preLen = curLen;
                curLen = 1;
            }
            if(preLen >= curLen){
                res++;
            }
        }
        return res;
    }
}
