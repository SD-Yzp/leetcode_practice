package com.study.thought.search.backtracking;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/4 17:05
 * @Version 1.0
 **/
public class SolveSudoku {
    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board){
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                int num = board[i][j] - '0';
                rowsUsed[i][num] = true;
                colsUsed[j][num] = true;
                cubesUsed[cubeNum(i,j)][num] = true;
            }
        }
        dfs(0,0);
    }

    private boolean dfs(int row, int col) {
        while(row < 9 && board[row][col]!='.'){
            row = col == 8 ? row+1 : row;
            col = col == 8 ? 0 : col+1;
        }
        if(row==9){
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if(rowsUsed[row][i] || colsUsed[col][i] ||cubesUsed[cubeNum(row,col)][i]){
                continue;
            }
            rowsUsed[row][i] = colsUsed[col][i] = cubesUsed[cubeNum(row,col)][i] = true;
            board[row][col] = (char)(i + '0');
            if(dfs(row,col)){
                return true;
            }
            board[row][col] = '.';
            rowsUsed[row][i] = colsUsed[col][i] = cubesUsed[cubeNum(row,col)][i] = false;
        }
        return false;
    }

    private int cubeNum(int i, int j) {
        int r = i / 3;
        int c = j / 3;
        return r*3 + c;
    }

}
