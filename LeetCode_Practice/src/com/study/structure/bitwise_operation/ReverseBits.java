package com.study.structure.bitwise_operation;

/**
 * @Description 反转一个数的比特位
 * @Author Yin
 * @Date 2020/6/25 16:22
 * @Version 1.0
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n&1);
            n >>>= 1;
        }
        return res;
    }
}
