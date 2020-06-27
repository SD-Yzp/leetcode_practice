package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合
 * @Author Yin
 * @Date 2020/6/3 20:29
 * @Version 1.0
 **/
public class Combine {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 0);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(n,0,k,list,res);
        return res;
    }

    private static void dfs(int n, int depth, int k, List<Integer> list, List<List<Integer>> res) {
        if(list.size()==k){
            // 注意每次要创建，不能直接加入，不然为空
            res.add(new ArrayList<>(list));
            return;
        }
        // 每次从深度+1的位置开始循环，保证上一次添加的数跟这一次添加的数值不相等，而且更大
        for (int i = depth+1; i <= n; i++) {
            list.add(i);
            dfs(n,i,k,list,res);
            list.remove((Integer)i);
        }
    }
}
