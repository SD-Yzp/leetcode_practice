package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description 零钱兑换
 * @Author Yin
 * @Date 2020/6/8 15:24
 * @Version 1.0
 **/
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if(i == coin){
                    f[i] = 1;
                }else if(f[i]==0 && f[i-coin]!=0){
                    f[i] = f[i-coin] + 1;
                }else if(f[i-coin]!=0){
                    f[i] = Math.min(f[i],f[i-coin]+1);
                }
            }
        }

        return f[amount]==0 ? -1 : f[amount];
    }
}
