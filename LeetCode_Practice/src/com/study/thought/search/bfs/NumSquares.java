package com.study.thought.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @Author Yin
 * @Date 2020/6/1 22:36
 * @Version 1.0
 **/
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }


    public static int numSquares(int n) {
        int res = 0;
        List<Integer> list = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        marked[n] = true;
        queue.offer(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            while(size-- > 0){
                Integer temp = queue.poll();
                for (Integer i : list) {
                    int next = temp - i;
                    if(next < 0){
                        break;
                    }
                    if(next == 0){
                        return res;
                    }
                    if(marked[next]){  // 之前找到的数一定不符合最小
                        continue;
                    }
                    queue.offer(next);
                    marked[next] = true;  // 标记出已经找到的数
                }
            }
        }

        return n;
    }

    /**
     * 生成小于n的平方数
     * @param n
     * @return 平方数所在的集合
     */
    private static List<Integer> generateSquares(int n){
        List<Integer> list = new ArrayList<>();
        int temp = (int) Math.sqrt(n);
        for (int i = 1; i <= temp; i++) {
            list.add(i * i);
        }
        return list;
    }
}
