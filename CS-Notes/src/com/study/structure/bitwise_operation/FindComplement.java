package com.study.structure.bitwise_operation;

/**
 * @Description 补数
 * @Author Yin
 * @Date 2020/6/25 17:38
 * @Version 1.0
 **/
public class FindComplement {
    public static void main(String[] args) {
        int res = findComplement2(2147483647);
        System.out.println(res);
    }
    public static int findComplement1(int num) {
        if(num > Math.pow(2,30)){
            return num ^ 0b1111111111111111111111111111111;
        }
        int temp =  (int)Math.pow(2,(int)(Math.log(num)/Math.log(2))+1) - 1;
        return num ^ temp;
    }

    public static int findComplement2(int num) {
        int temp = num;
        temp |= temp >> 1;
        temp |= temp >> 2;
        temp |= temp >> 4;
        temp |= temp >> 8;
        temp |= temp >> 16;
        return num^temp;
    }

    public static int findComplement3(int num) {
        if (num==0){
            return 1;
        }
        int mask = 1 << 30;
        while((num & mask) == 0){
            mask >>= 1;
        }
        mask = (mask << 1) - 1;
        return mask ^ num;
    }

    public static int findComplement4(int num) {
        if (num == 0){
            return 1;
        }
        int mask = Integer.highestOneBit(num);
        mask = (mask << 1) - 1;
        return num ^ mask;
    }
}
