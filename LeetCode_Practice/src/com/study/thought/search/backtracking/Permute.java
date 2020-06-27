package com.study.thought.search.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description 全排列
 * @Author Yin
 * @Date 2020/6/3 18:46
 * @Version 1.0
 **/
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(nums,0,stack,marked,res);
        return res;
    }

    private static void dfs(int[] nums, int depth, Deque<Integer> stack, boolean[] marked, List<List<Integer>> res) {
        if(depth==nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!marked[i]){
                stack.push(nums[i]);
                marked[i] = true;
                dfs(nums,depth+1,stack,marked,res);
                marked[i] = false;
                stack.pop();
            }
        }
    }
}
