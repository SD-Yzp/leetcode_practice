package com.study.thought.search.dfs;

/**
 * @Description 朋友圈  本题为无向图
 * @Author Yin
 * @Date 2020/6/2 17:27
 * @Version 1.0
 **/
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] M = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1},
                /*{1,1,0},
                {1,1,0},
                {0,1,1}*/
                // {1}
                /*{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}*/
                /*{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},
                {0,0,0,1,0,1,0,0,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,1,1,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,1,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,1,0,1,1,0,0,0},
                {0,0,1,0,1,1,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
                {0,1,0,1,0,0,0,0,1,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,1,0,1}*/
        };
        System.out.println(findCircleNum(M));
    }

    /**
     * 答案
     * @param M
     * @return
     */
    public static int findCircleNum_better(int[][] M) {
        int res = 0;
        int n = M.length;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!marked[i]){
                dfs_better(M,i,marked);
                res++;
            }
        }
        return res;
    }

    private static void dfs_better(int[][] M,int i,boolean[] marked){
        marked[i] = true;
        for (int j = 0; j < M.length; j++) {
            if(M[i][j]==1 && !marked[j]){
                dfs_better(M,j,marked);
            }
        }
    }

    /**
     * 错误的思路
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int res = 0;
        int n = M.length;
        for (int i = 0; i < n; i++) {
            // 这个人是否已经在一个朋友圈内
            for (int j = i+1; j < n; j++) {
                if(M[i][j]==1){
                    boolean isFriend = M[i][i]==0;
                    res++;
                    if(isFriend){
                        res--;
                    }
                    dfs(M,i,j);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] M,int row,int line){
        if(row>M.length-1 || line>M.length-1 || row<0 || line<0 ){
            return;
        }
        M[row][line] = 0;
        dfs(M,row+1,line);  //每一列置0  注意列置0是每行每次加一
    }
}
