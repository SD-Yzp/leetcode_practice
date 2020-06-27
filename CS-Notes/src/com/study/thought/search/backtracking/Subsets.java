package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 子集 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Author Yin
 * @Date 2020/6/4 16:04
 * @Version 1.0
 **/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,0, list,res);
        return res;
    }

    private static void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,i+1, list,res);
            list.remove((Integer)nums[i]);
        }
    }
}
