package com.study.structure.array;

/**
 * @Description 对角元素相等的矩阵
 * @Author Yin
 * @Date 2020/6/14 20:37
 * @Version 1.0
 **/
public class IsToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                /*{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}*/
                /*{1,   2,  3 ,  4},
                {5,   1,  2 ,  3},
                {3,   5,  1 ,  2},
                {3,   3,  5 ,  1}*/
                /*{0,33,98},
                {34,22,33}*/
                {36,59,71,15,26,82,87},
                {56,36,59,71,15,26,82},
                {15,0,36,59,71,15,26}
        };
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 ||matrix[0].length==0){
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start_row = 0;
        int start_line = n-1;
        int row = start_row;
        int line = start_line;
        while (true){
            int standard = matrix[row][line];
            row++;
            line++;
            if(row == m || line == n){
                start_line--;
                if(start_line < 0 && start_row < m-1){
                    start_line = 0;
                    start_row++;
                }
                if(start_row == m-1){
                    break;
                }
                row = start_row;
                line = start_line;
            }else{
                if(matrix[row][line] != standard){
                    return false;
                }
            }
        }
        return true;
    }
}
