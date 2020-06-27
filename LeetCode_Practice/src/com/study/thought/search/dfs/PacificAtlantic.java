package com.study.thought.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/2 21:18
 * @Version 1.0
 **/
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> res = pacificAtlantic(matrix);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] marked_P = new boolean[m][n];  // 标记可以到达Pacific的坐标
        boolean[][] marked_A = new boolean[m][n];  // 标记可以到达Atlantic的坐标
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < m; i++) {
            dfs(matrix,i,0,marked_P,directions);
            dfs(matrix,i,n-1,marked_A,directions);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix,0,i,marked_P,directions);
            dfs(matrix,m-1,i,marked_A,directions);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(marked_A[i][j]&&marked_P[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    private static void dfs(int[][] matrix,int row,int line,boolean[][] marked,int[][] directions){
        if(marked[row][line]){
            return;
        }
        marked[row][line] = true;
        for (int[] direction : directions) {
            int temp_row = row + direction[0];
            int temp_line = line + direction[1];
            if(temp_line<matrix[0].length&&temp_line>=0&&temp_row<matrix.length&&temp_row>=0&&matrix[temp_row][temp_line]>=matrix[row][line]){
                dfs(matrix,temp_row,temp_line,marked,directions);
            }
        }
    }
}
