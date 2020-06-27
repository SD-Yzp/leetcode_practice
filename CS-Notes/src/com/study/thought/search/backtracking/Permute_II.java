package com.study.thought.search.backtracking;

import java.util.*;

/**
 * @Description 全排列2  有重复元素
 * @Author Yin
 * @Date 2020/6/3 20:01
 * @Version 1.0
 **/
public class Permute_II {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] marked = new boolean[nums.length];
        Arrays.sort(nums); // 排序，将重复的连在一起
        dfs(nums,0,stack,marked,res);
        return res;
    }

    private static void dfs(int[] nums, int depth, Deque<Integer> stack, boolean[] marked, List<List<Integer>> res) {
        if(depth==nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前值等于上一个值，并且上一个值还没被标记，说明这个数开头重复了，直接跳过
            if(i!=0 && nums[i]==nums[i-1] && !marked[i-1]){
                continue;
            }
            if(!marked[i]){
                stack.push(nums[i]);
                marked[i]=true;
                dfs(nums,depth+1,stack,marked,res);
                marked[i]=false;
                stack.pop();
            }
        }
    }
}
