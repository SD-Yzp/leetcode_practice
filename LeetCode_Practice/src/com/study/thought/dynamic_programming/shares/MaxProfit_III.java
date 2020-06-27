package com.study.thought.dynamic_programming.shares;

/**
 * @Description 有次数限制
 * @Author Yin
 * @Date 2020/6/9 21:11
 * @Version 1.0
 **/
public class MaxProfit_III {
    public static void main(String[] args) {
        // int[] prices = {1,2,3,4,5};
        int[] prices = {3,2,6,5,0,3};
        // int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit_practice(prices));
    }

    public static int maxProfit(int[] prices){
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                if(i != 0){
                    dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }else{
                    dp[0][1][1] = -prices[0];  // 如果已经交易一次，那持有股票的时候一定是负值
                    dp[0][2][1] = -prices[0];
                }
            }
        }
        return dp[prices.length-1][2][0];
        /*  错误
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len+1][3][2];
        dp[0][1][1] = -prices[0];  // 如果已经交易一次，那持有股票的时候一定是负值
        dp[0][2][1] = -prices[0];
        for (int i = 1; i <= len; i++) {
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k][0]-prices[i-1]);
            }
        }
        return dp[len][2][0];*/
    }

    public static int maxProfit_better(int[] prices){
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }


    public static int maxProfit_practice(int[] prices){
        int dp_i_1_0 = 0;
        int dp_i_1_1 = Integer.MIN_VALUE;
        int dp_i_2_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE;
        for (int price : prices) {   // 应该按照未使用的顺序来写，不然会出现本次计算的结果覆盖上次，从而让后边的步骤使用了本次的值
            dp_i_2_0 = Math.max(dp_i_2_0,dp_i_2_1+price);
            dp_i_2_1 = Math.max(dp_i_2_1,dp_i_1_0-price);
            dp_i_1_0 = Math.max(dp_i_1_0,dp_i_1_1+price);
            dp_i_1_1 = Math.max(dp_i_1_1,-price); // dp_i_0_0永远是0
        }
        return dp_i_2_0;
    }
}
