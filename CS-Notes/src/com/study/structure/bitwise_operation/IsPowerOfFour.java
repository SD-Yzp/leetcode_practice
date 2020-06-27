package com.study.structure.bitwise_operation;

/**
 * @Description 是否是4的幂
 * @Author Yin
 * @Date 2020/6/25 17:13
 * @Version 1.0
 **/
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num){
        if( num < 0 || (num & (num -1 )) != 0){
            return false;
        }
        num |= (num - 1);
        int count = Integer.bitCount(num);
        return count % 2 != 0;
    }
}
