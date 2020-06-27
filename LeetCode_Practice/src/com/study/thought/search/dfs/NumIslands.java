package com.study.thought.search.dfs;

/**
 * @Description 岛屿数量
 * @Author Yin
 * @Date 2020/6/2 16:56
 * @Version 1.0
 **/
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 方向
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j,directions);
                }
            }
        }
        return res;
    }

    /**
     * 将连通的置0
     * @param grid
     * @param row
     * @param line
     * @param directions
     */
    private static void dfs(char[][] grid,int row,int line,int[][] directions){
        if(grid[row][line]=='0'){
            return;
        }
        grid[row][line] = '0';
        for (int[] direction : directions) {
            int temp_row = direction[1] + row;
            int temp_line = direction[0] + line;
            if(temp_row < grid.length && temp_row >= 0 && temp_line < grid[0].length && temp_line >= 0){
                dfs(grid,temp_row,temp_line,directions);
            }
        }
    }
}
