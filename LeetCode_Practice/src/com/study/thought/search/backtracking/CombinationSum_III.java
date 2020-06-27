package com.study.thought.search.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description 组合总和三 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * @Author Yin
 * @Date 2020/6/4 15:38
 * @Version 1.0
 **/
public class CombinationSum_III {
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 9);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(k,n,1,stack,res);
        return res;
    }

    private static void dfs(int k, int target, int start, Deque<Integer> stack, List<List<Integer>> res) {
        if(stack.size()==k && target==0){
            res.add(new ArrayList<>(stack));
        }
        for (int i = start; i <= 9; i++) {
            if(i <= target && stack.size()<k){
                stack.push(i);
                dfs(k,target-i,i+1,stack,res);
                stack.pop();
            }
        }
    }

}
