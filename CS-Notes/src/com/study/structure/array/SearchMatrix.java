package com.study.structure.array;

/**
 * @Description 有序矩阵查找
 * @Author Yin
 * @Date 2020/6/13 15:31
 * @Version 1.0
 **/
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix,20));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length == 0||matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 从左下角开始找
        int row = m-1;
        int line = 0;
        while(row>=0 && line<n){
            // 往上找
            if(target<matrix[row][line]){
                row--;
            }else if(target>matrix[row][line]){  // 向右
                line++;
            }else if(target==matrix[row][line]){
                return true;
            }
        }
        return false;
    }
}
