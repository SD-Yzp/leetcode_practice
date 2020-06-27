package com.study.structure.bitwise_operation;

/**
 * @Description 不使用+ - 计算两数和
 * @Author Yin
 * @Date 2020/6/25 21:05
 * @Version 1.0
 **/
public class GetSum {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b,( a & b ) << 1);
    }
}
