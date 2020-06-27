package com.study.structure.bitwise_operation;

/**
 * @Description 一个数的位级是否出现连续的0和1 出现返回false   题目说明参数都是正整数
 * @Author Yin
 * @Date 2020/6/25 17:20
 * @Version 1.0
 **/
public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if(n==1||n==0){
            return true;
        }
        do{
            int pre = n & 1;
            n >>= 1;
            int now = n & 1;
            if(pre == now){
                return false;
            }
        }while (n != 0);
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        int res = n ^ (n >> 1);
        return (res & (res + 1)) == 0;
    }
}
