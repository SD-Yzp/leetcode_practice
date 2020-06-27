package com.study.thought.dynamic_programming.shares;

/**
 * @Description 设置k笔交易
 * @Author Yin
 * @Date 2020/6/9 22:31
 * @Version 1.0
 **/
public class MaxProfit_IV {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(2,prices));
    }
    public static int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        if(k >= len/2){  //转换成普通的股票问题
            int res = 0;
            for (int i = 1; i < len; i++) {
                if(prices[i]>prices[i-1]){
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }
        int[][][] dp = new int[len][k+1][2];
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if(i==0){
                    dp[i][j][1] = -prices[0];  // dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])前者是-infinity，后者是-prices[i]
                }else{
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[len-1][k][0];
    }
}
