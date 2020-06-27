package com.study.thought.dynamic_programming.string_edit;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/10 19:27
 * @Version 1.0
 **/
public class MinSteps {
    public int minSteps(int n){
        int res = 0;
        int d = 2;
        while(n>1){
            while (n%d==0){
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }
}
