package com.study.structure.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description 每日温度
 * @Author Yin
 * @Date 2020/6/15 19:11
 * @Version 1.0
 **/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {73/*, 74, 75, 71, 69, 72, 76, 73*/};
        int[] temperatures = dailyTemperatures(T);
        System.out.println(Arrays.toString(temperatures));
    }

    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
