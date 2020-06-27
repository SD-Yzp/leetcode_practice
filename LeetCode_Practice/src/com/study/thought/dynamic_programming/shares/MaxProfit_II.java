package com.study.thought.dynamic_programming.shares;

/**
 * @Description 含手续费
 * @Author Yin
 * @Date 2020/6/9 17:29
 * @Version 1.0
 **/
public class MaxProfit_II {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices,fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            if(dp_i_1!=Integer.MIN_VALUE){   // price-fee可能为负数，int的最小值加负数会超界变成最大值
                dp_i_0 = Math.max(temp,dp_i_1+price-fee);
            }
            dp_i_1 = Math.max(dp_i_1,temp-price);
        }
        return Math.max(dp_i_0,dp_i_1);
    }
}
