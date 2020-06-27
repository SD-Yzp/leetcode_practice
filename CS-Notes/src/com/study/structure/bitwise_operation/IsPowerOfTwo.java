package com.study.structure.bitwise_operation;

/**
 * @Description 2的幂
 * @Author Yin
 * @Date 2020/6/25 16:36
 * @Version 1.0
 **/
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        int count = 0;
        while (n != 0){
            count += (n & 1);
            n >>= 1;
        }
        return count==1;
    }

    /**
     * 利用1000 & 0111 = 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
