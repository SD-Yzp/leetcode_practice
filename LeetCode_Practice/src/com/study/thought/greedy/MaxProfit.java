package com.study.thought.greedy;

/**
 * @Description  买卖股票最大的收益
 * @Author Yin
 * @Date 2020/5/30 17:01
 * @Version 1.0
 **/
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        int[] f = new int[len];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(prices[i],min);
            int res = prices[i] - min;
            f[i] = Math.max(f[i-1],res);
        }

        return f[len-1];
    }
}
