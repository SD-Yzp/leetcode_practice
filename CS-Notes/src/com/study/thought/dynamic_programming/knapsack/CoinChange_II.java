package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description 零钱兑换 II
 * @Author Yin
 * @Date 2020/6/8 15:34
 * @Version 1.0
 **/
public class CoinChange_II {
    public static void main(String[] args) {
        int[] coins = {10};
        System.out.println(change(0,coins));
    }

    /**
     * 本题要求amount为0时输出为1
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        if(coins==null){
            return 0;
        }
        int[] f = new int[amount+1];
        f[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                f[i] += f[i-coin];
            }
        }
        return f[amount];
    }
}
