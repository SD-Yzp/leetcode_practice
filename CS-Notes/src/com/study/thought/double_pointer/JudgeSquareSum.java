package com.study.thought.double_pointer;

/**
 * @Description 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * @Author Yin
 * @Date 2020/5/28 15:30
 * @Version 1.0
 **/
public class JudgeSquareSum {
    public static void main(String[] args){
        System.out.println(judgeSquareSum(1000000));
    }


    public static boolean judgeSquareSum(int c) {
        // 1 直接返回 0 + 1
        if(c == 1){
            return true;
        }
        // 双指针
        int a = 0;
        int b = (int) Math.sqrt(c);
        int res;
        // 停止条件 可能相等
        while(a <= b){
            res = a*a + b*b;
            // 找到返回
            if(res==c){
                return true;
            // 结果小于c，头指针往后
            }else if(res<c){
                a++;
            // 结果大于c，尾指针往前
            }else{
                b--;
            }
        }
        // 没有找到
        return false;
    }
}
