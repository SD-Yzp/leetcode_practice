package com.study.structure.array;

/**
 * @Description 最多能完成排序的块
 * @Author Yin
 * @Date 2020/6/15 16:13
 * @Version 1.0
 **/
public class MaxChunksToSorted {
    public static void main(String[] args) {
        int[] arr = {0,1,3,4,2};
        System.out.println(maxChunksToSorted(arr));
    }
    public static int maxChunksToSorted(int[] arr) {
        int res = 0;
        int index = 0;
        int len = arr.length;
        while(index < len){
            if(index == arr[index]){
                index++;
            }else{
                int end = arr[index];
                for (int i = index; i <= end; i++) {
                    // index到nums[index]之间可能存在大于nums[index]的值
                    if(arr[i] > end){
                        end = arr[i];
                    }
                }
                index = end + 1;
            }
            res++;
        }
        return res;
    }
}
