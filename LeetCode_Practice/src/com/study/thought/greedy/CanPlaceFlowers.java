package com.study.thought.greedy;

/**
 * @Description 种花问题
 * @Author Yin
 * @Date 2020/5/30 17:27
 * @Version 1.0
 **/
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(canPlaceFlowers(nums,1));
    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed==null||flowerbed.length==0||n>flowerbed.length){
            return false;
        }
        if(n==0||(flowerbed.length==1&&flowerbed[0]==0&&n==1)){
            return true;
        }
        if(flowerbed.length==1&&n==1){
            return false;
        }
        int len = flowerbed.length;
        int count = 0;
        int position = 0;
        for (int i = 0; i < len; i++) {
            // 对边界处理
            if(i==0){
                count++;
            }
            // 判断当前有没有,有花,置0;没有,count++
            if(flowerbed[i]==0){
                count++;
            }else{
                count=0;
            }
            // 记录可能种花的位置
            if(count==2){
                position = i;
            }
            // 满足条件，将花种下
            if(count==3){
                flowerbed[position] = 1;
                n--;
                count=1;
                if(n==0){
                    return true;
                }
            }
        }
        // 特殊处理最后位置  只有一种情况
        if(flowerbed[len-2]==0&&flowerbed[len-1]==0){
            n--;
        }


        return n==0;
    }
}
