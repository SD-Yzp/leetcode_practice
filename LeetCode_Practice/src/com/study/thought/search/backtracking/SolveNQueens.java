package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description N皇后问题
 * @Author Yin
 * @Date 2020/6/4 19:00
 * @Version 1.0
 **/
public class SolveNQueens {
    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    private int n;

    public List<List<String>> solveNQueens(int n){
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i],'.');
        }
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2*n-1];
        diagonals135Used = new boolean[2*n-1];
        this.n = n;
        dfs(0);
        return solutions;
    }

    private void dfs(int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            solutions.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonal45Idx = row + col;
            int diagonal135Idx = n - 1 - (row - col);
            if(colUsed[col] || diagonals45Used[diagonal45Idx] || diagonals135Used[diagonal135Idx]){
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonal45Idx] = diagonals135Used[diagonal135Idx] = true;
            dfs(row + 1);
            colUsed[col] = diagonals45Used[diagonal45Idx] = diagonals135Used[diagonal135Idx] = false;
            nQueens[row][col] = '.';
        }
    }
}
