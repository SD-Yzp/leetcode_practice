package com.study.thought.search.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二进制矩阵中的最短路径
 * @Author Yin
 * @Date 2020/6/1 19:07
 * @Version 1.0
 **/
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
                /*{0,1},
                {1,0}*/
                /*{0,0,0},
                {1,1,0},
                {1,1,1}*/
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    /**
     *   注意 x y 的位置
     * @param grid
     * @return
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0||grid[0][0]==1){
            return -1;
        }
        // 获取行列
        int m = grid.length;
        int n = grid[0].length;
        // 存放方向
        int[][] directions = {{-1,0},{-1,-1},{0,-1},{1,0},{0,1},{1,-1},{-1,1},{1,1}};
        // 存放坐标
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            while(size-- > 0){
                Pair<Integer, Integer> pair = queue.poll();
                Integer x = pair.getKey();
                Integer y = pair.getValue();
                // 不判断会超时
                if(grid[y][x]==1){
                    continue;
                }
                // 到过的地方置1，保证下一次遍历不会再来
                grid[y][x] = 1;
                // 到了右下角
                if(y == m-1 && x == n-1){
                    return res;
                }
                for (int[] direction : directions) {
                    int temp_x = x + direction[1];
                    int temp_y = y + direction[0];
                    if(temp_x<0||temp_x>n-1||temp_y<0||temp_y>m-1){
                        continue;
                    }
                    if(grid[temp_y][temp_x]==0){
                        queue.offer(new Pair<>(temp_x,temp_y));
                    }
                }
            }
        }
        return -1;
    }
}
