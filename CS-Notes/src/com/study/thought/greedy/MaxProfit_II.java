package com.study.thought.greedy;

/**
 * @Description 买卖股票的最大收益 II
 * @Author Yin
 * @Date 2020/5/30 17:23
 * @Version 1.0
 **/
public class MaxProfit_II {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int d = prices[i+1] - prices[i];
            maxProfit += Math.max(d, 0);
        }

        return maxProfit;
    }
}
