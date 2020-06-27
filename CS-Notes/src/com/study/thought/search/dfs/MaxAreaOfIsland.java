package com.study.thought.search.dfs;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 岛屿最大面积
 * @Author Yin
 * @Date 2020/6/2 16:00
 * @Version 1.0
 **/
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
                // {0,0,0,0,0,0,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland_dfs(grid));
    }

    /**
     * 广度优先
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland_bfs(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int res = 0;
        // 定义方向
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        // 栈中存放坐标
        Deque<Pair<Integer,Integer>> stack = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    int area = 1;
                    stack.push(new Pair<>(i,j));
                    grid[i][j] = 0;
                    while(!stack.isEmpty()){
                        Pair<Integer, Integer> coordinate = stack.pop();
                        for (int[] direction : directions) {
                            int row = direction[0] + coordinate.getKey();
                            int line = direction[1] + coordinate.getValue();
                            if(row>m-1 || row<0 || line>n-1 || line<0){
                                continue;
                            }
                            if(grid[row][line]==1){
                                stack.push(new Pair<>(row,line));
                                grid[row][line] = 0;
                                area++;
                            }
                        }
                    }
                    res = Math.max(res,area);
                }
            }
        }

        return res;
    }


    /**
     * 深度优先
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland_dfs(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int res = 0;
        // 定义方向
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j,directions);
                    res = Math.max(res,area);
                }
            }
        }

        return res;
    }


    private static int dfs(int[][] grid,int row,int line,int[][] directions){
        if(grid[row][line]==0){
            return 0;
        }
        int area = 1;
        grid[row][line] = 0;
        for (int[] direction : directions) {
            int temp_row = row + direction[0];
            int temp_line = line + direction[1];
            if(temp_row>grid.length-1 || temp_row<0 || temp_line>grid[0].length-1 || temp_line<0){
                continue;
            }
            area += dfs(grid,temp_row,temp_line,directions);
        }
        return area;
    }
}
