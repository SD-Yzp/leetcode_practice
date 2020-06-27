package com.study.thought.search.backtracking;

import java.util.*;

/**
 * @Description 组合求和   有重复元素，每个元素只能用一次
 * @Author Yin
 * @Date 2020/6/4 15:21
 * @Version 1.0
 **/
public class CombinationSum_II {
    public static void main(String[] args) {
        // int[] candidates = {2,3,6,7};
        // int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates = {2,5,2,1,2};
        List<List<Integer>> res = combinationSum2(candidates, 5);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] marked = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,0,stack,marked,target,res);
        return res;
    }

    private static void dfs(int[] candidates,int depth, Deque<Integer> stack, boolean[] marked, int target, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(stack));
        }
        for (int i = depth; i < candidates.length; i++) {
            // 如果上一个值跟这一个相等 并且上一个值还没有用，说明出现重复
            if(i != 0 && candidates[i]==candidates[i-1] && !marked[i-1]){
                continue;
            }
            if(candidates[i] <= target){
                stack.push(candidates[i]);
                marked[i] = true;
                dfs(candidates,i+1,stack,marked,target-candidates[i],res);
                marked[i] = false;
                stack.pop();
            }
        }
    }
}
