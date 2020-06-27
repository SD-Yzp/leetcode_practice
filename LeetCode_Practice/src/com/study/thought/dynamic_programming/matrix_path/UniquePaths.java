package com.study.thought.dynamic_programming.matrix_path;

/**
 * @Description 不同路径
 * @Author Yin
 * @Date 2020/6/5 20:40
 * @Version 1.0
 **/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths_math(7,3));
    }
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

    public static int uniquePaths_math(int m, int n) {
        int s = m + n - 2;  // 总移动次数
        int d = m - 1; // 向下移动的次数
        long res = 1;  // 溢出问题
        // 从s中选出d个位置的组合
        for (int i = 1; i <= d; i++) {
            res = res * (s - d + i) / i;
        }
        return (int)res;
    }
}
