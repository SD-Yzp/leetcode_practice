package com.study.thought.search.dfs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 被围绕的区域
 * @Author Yin
 * @Date 2020/6/2 19:37
 * @Version 1.0
 **/
public class Solve {
    public static void main(String[] args) {
        char[][] board = {
                /*{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},*/
                {'O'}
        };
        for (char[] c : board) {
            for (char c1 : c) {
                System.out.print(c1+" ");
            }
            System.out.println();
        }
        System.out.println("=======");
        solve(board);
        for (char[] c : board) {
            for (char c1 : c) {
                System.out.print(c1+" ");
            }
            System.out.println();
        }
    }


    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        //处理边界  先换为X  标记出来
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < m; i++) {
            if(board[i][0]=='O'){
                dfs(board,i,0,list,directions);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,list,directions);
            }

        }
        for (int i = 0; i < n; i++) {
            if(board[0][i]=='O'){
                dfs(board,0,i,list,directions);
            }
            if(board[m-1][i]=='O'){
                dfs(board,m-1,i,list,directions);
            }
        }

        // 处理内侧
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O'){
                    dfs(board,i,j,directions);
                }
            }
        }

        //将外侧变回
        for (Pair<Integer, Integer> p : list) {
            board[p.getKey()][p.getValue()] = 'O';
        }

    }

    private static void dfs(char[][] board, int row, int line, List<Pair<Integer, Integer>> list,int[][] directions) {
        if(row>board.length-1 || row<0 || line>board[0].length-1 || line<0 || board[row][line]=='X'){
            return;
        }
        board[row][line] = 'X';
        list.add(new Pair<>(row,line));
        for (int[] direction : directions) {
            int temp_row = row + direction[0];
            int temp_line = line + direction[1];
            dfs(board,temp_row,temp_line,list,directions);
        }
    }

    private static void dfs(char[][] board, int row, int line, int[][] directions) {
        if(row>board.length-1 || row<0 || line>board[0].length || line<0 || board[row][line]=='X'){
            return;
        }
        board[row][line] = 'X';
        for (int[] direction : directions) {
            int temp_row = row + direction[0];
            int temp_line = line + direction[1];
            dfs(board,temp_row,temp_line,directions);
        }
    }
}
