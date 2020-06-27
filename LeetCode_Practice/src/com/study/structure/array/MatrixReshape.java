package com.study.structure.array;

import java.util.Arrays;

/**
 * @Description 重塑矩阵
 * @Author Yin
 * @Date 2020/6/13 15:20
 * @Version 1.0
 **/
public class MatrixReshape {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2},
                {3,4}
        };
        int[][] res = matrixReshape(nums, 1, 4);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums==null||nums.length==0||nums[0].length==0){
            return nums;
        }
        int m = nums.length;
        int n = nums[0].length;
        if(m*n!=r*c){
            return nums;
        }
        int row = 0;
        int line = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][line] = nums[i][j];
                row = line == c-1 ? row+1 : row;
                line = line == c-1 ? 0 : line+1;
            }
        }
        return res;
    }
}
