package com.study.thought.dynamic_programming.array_interval;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/5 21:53
 * @Version 1.0
 **/
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        int[] A = {0,1,2/*,3,4,6,7,8,10,12,14,15*/};
        System.out.println(numberOfArithmeticSlices(A));
    }
    public static int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        if(A==null||A.length<=2){
            return res;
        }
        int len = A.length;
        boolean isSuccessive = false;  // 是否连续
        int successiveLen = 0;  // 连续长度-3  方便计算
        for (int i = 2; i < len; i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                if(isSuccessive){
                    successiveLen++;
                }else{
                    successiveLen = 1;
                    isSuccessive = true;
                }
            }else{
                if(isSuccessive){
                    res += (1 + successiveLen)*successiveLen/2;
                    isSuccessive = false;
                }
            }
        }
        // 可能在最后位置
        if(isSuccessive){
            res += (1 + successiveLen)*successiveLen/2;
        }


        return res;
    }
}
