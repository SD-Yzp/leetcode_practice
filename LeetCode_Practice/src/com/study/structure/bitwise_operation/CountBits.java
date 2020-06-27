package com.study.structure.bitwise_operation;

/**
 * @Description 统计0-n二进制表示中1的个数
 * @Author Yin
 * @Date 2020/6/25 21:58
 * @Version 1.0
 **/
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i&(i-1)] + 1;
        }
        return res;
    }
}
