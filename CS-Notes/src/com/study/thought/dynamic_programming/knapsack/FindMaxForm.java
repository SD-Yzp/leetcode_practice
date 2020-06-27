package com.study.thought.dynamic_programming.knapsack;

/**
 * @Description TODO
 * @Author Yin
 * @Date 2020/6/7 19:25
 * @Version 1.0
 **/
public class FindMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs==null||strs.length==0){
            return 0;
        }
        int[][] f = new int[m+1][n+1];
        for (String s : strs) {
            int one_count = 0;
            int zero_count = 0;
            for (char c : s.toCharArray()) {
                if(c=='0'){
                    zero_count++;
                }else{
                    one_count++;
                }
            }
            for (int i = m; i >= zero_count ; i--) {
                for (int j = n; j >= one_count ; j--) {
                    f[i][j] = Math.max(f[i][j],f[i-zero_count][j-one_count]+1);
                }
            }
        }
        return f[m][n];
    }
}
