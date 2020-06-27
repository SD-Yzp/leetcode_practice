package com.study.structure.array;

/**
 * @Description 第K个最小的数
 * @Author Yin
 * @Date 2020/6/13 22:04
 * @Version 1.0
 **/
public class KthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {
                /*{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}*/
                {1,   4,  7},
                {2,   5,  8},
                {3,   6,  9}
        };
        System.out.println(kthSmallest(matrix,8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while (low <= high){
            int mid = low + (high - low)/2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
