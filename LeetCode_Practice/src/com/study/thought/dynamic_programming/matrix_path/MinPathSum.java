package com.study.thought.dynamic_programming.matrix_path;

/**
 * @Description 最小路径和
 * @Author Yin
 * @Date 2020/6/5 20:23
 * @Version 1.0
 **/
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                /*{1,3,1},
                {1,5,1},
                {4,2,1}*/
                {1}
        };
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        if(grid == null||grid.length == 0||grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        // 求出第一列初始值
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        // 求出第一行初始值
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
            }
        }
        // for (int i = 0; i < m; i++) {
        //     System.out.println(Arrays.toString(f[i]));
        // }
        return f[m-1][n-1];
    }
}
