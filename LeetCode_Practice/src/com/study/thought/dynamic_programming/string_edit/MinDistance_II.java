package com.study.thought.dynamic_programming.string_edit;

/**
 * @Description 编辑距离  增删改
 * @Author Yin
 * @Date 2020/6/10 15:59
 * @Version 1.0
 **/
public class MinDistance_II {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
    public static int minDistance(String word1,String word2){
        if(word1==null||word2==null){
            return 0;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int temp = Math.min(dp[i-1][j],dp[i][j-1]);
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + Math.min(temp,dp[i-1][j-1]-1);
                }else{
                    dp[i][j] = 1 + Math.min(temp,dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
