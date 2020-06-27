package com.study.structure.bitwise_operation;

/**
 * @Description 汉明距离
 * @Author Yin
 * @Date 2020/6/25 15:28
 * @Version 1.0
 **/
public class HammingDistance {
    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while(res != 0){
            int temp = res & 1;
            if(temp == 1){
                count++;
            }
            res >>= 1;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while(res != 0){
            res &= res-1;
            count++;
        }
        return count;
    }
}
