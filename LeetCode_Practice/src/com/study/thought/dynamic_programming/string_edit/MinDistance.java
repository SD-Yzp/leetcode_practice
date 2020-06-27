package com.study.thought.dynamic_programming.string_edit;

/**
 * @Description 两个字符串的删除操作
 * @Author Yin
 * @Date 2020/6/10 15:28
 * @Version 1.0
 **/
public class MinDistance {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return len1 + len2 - 2*dp[len1][len2];
    }
}
