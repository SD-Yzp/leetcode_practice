package com.study.thought.dynamic_programming.split_integer;

/**
 * @Description 最长公共子序列
 * @Author Yin
 * @Date 2020/6/6 22:11
 * @Version 1.0
 **/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "psnw";
        String s2 = "vozsh";
        System.out.println(longestCommonSubsequence(s1,s2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] f = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + 1;
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                }
            }
        }
        return f[n1][n2];
    }
}
