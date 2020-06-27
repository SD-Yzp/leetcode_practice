package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 子集2 含重复元素
 * @Author Yin
 * @Date 2020/6/4 16:23
 * @Version 1.0
 **/
public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        Arrays.sort(nums); // 预处理  排序
        dfs(nums,0,marked,list,res);
        return res;
    }

    private static void dfs(int[] nums, int start, boolean[] marked, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i!=0 && nums[i]==nums[i-1] && !marked[i-1]){
                continue;
            }
            list.add(nums[i]);
            marked[i] = true;
            dfs(nums,i+1,marked,list,res);
            marked[i] = false;
            list.remove((Integer)nums[i]);
        }
    }
}
