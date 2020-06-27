package com.study.thought.dynamic_programming.shares;

/**
 * @Description 含冷冻期
 * @Author Yin
 * @Date 2020/6/9 16:46
 * @Version 1.0
 **/
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit_better(prices));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] f = new int[len+1][2];
        f[0][0] = 0;
        f[0][1] = Integer.MIN_VALUE;
        int pre = 0; // 表示f[-1][0]
        for (int i = 1; i <= prices.length; i++) {
            if(i-2 >= 0){
                pre = f[i-2][0];
            }
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]+prices[i-1]);
            f[i][1] = Math.max(f[i-1][1],pre-prices[i-1]);    // 这里的prices[i-1]指的是第i天的价格，因为价格下标从0开始
        }
        return Math.max(f[len][0],f[len][1]);
    }

    public static int maxProfit_better(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 表示dp[i-2][0]  前天不持有股票
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(temp,dp_i_1+price);
            dp_i_1 = Math.max(dp_i_1,dp_pre_0-price);
            dp_pre_0 = temp;
        }
        return Math.max(dp_i_0,dp_i_1);
    }
}
