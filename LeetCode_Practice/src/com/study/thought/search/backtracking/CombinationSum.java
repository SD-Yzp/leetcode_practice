package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合求和
 * @Author Yin
 * @Date 2020/6/3 21:22
 * @Version 1.0
 **/
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = combinationSum(candidates, 8);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates,0,target,list,res);
        return res;
    }

    private static void dfs(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] <= target){
                list.add(candidates[i]);
                dfs(candidates,i,target-candidates[i],list,res);
                list.remove((Integer)candidates[i]);
            }
        }
    }
}
