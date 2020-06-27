package com.study.thought.search.backtracking;

/**
 * @Description 单词搜索
 * @Author Yin
 * @Date 2020/6/3 16:51
 * @Version 1.0
 **/
public class Exist {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
                // {'A','A'},

        };
        System.out.println(exist(board,"ABCB"));

    }

    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{1,0},{0,-1},{0,1},{-1,0}};
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到第一个字母 进入深度搜索
                if(board[i][j]==word.charAt(0)){
                    if (dfs(board,word,0,marked,directions,i,j)) {
                        return true;
                    }
                }
            }
        }
        // 没有找到结果
        return false;
    }

    private static boolean dfs(char[][] board, String word, int depth, boolean[][] marked, int[][] directions, int i, int j) {
        // 0 说明两个值相同
        int temp = word.charAt(depth) - board[i][j];
        if(temp==0){
            if(word.length()==depth+1){
                return true;
            }
            marked[i][j] = true;
            for (int[] direction : directions) {
                int row = i + direction[0];
                int line = j + direction[1];
                if(row < 0 || row >= board.length || line < 0|| line >= board[0].length || marked[row][line]){
                    continue;
                }

                if(dfs(board,word,depth+1,marked,directions,row,line)){
                    return true;
                }

            }
            marked[i][j] = false;
        }
        return false;
    }

}
