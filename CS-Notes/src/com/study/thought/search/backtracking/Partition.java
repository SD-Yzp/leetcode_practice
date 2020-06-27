package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 分割回文串
 * @Author Yin
 * @Date 2020/6/4 16:32
 * @Version 1.0
 **/
public class Partition {
    public static void main(String[] args) {
        List<List<String>> res = partition("aab");
        for (List<String> list : res) {
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s,list,res);
        return res;
    }

    private static void dfs(String s, List<String> list, List<List<String>> res) {
        if(s.length()==0){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s,0,i)){
                list.add(s.substring(0,i+1));
                dfs(s.substring(i+1),list,res);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
