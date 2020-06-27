package com.study.thought.search.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description 电话号码的字母组合
 * @Author Yin
 * @Date 2020/6/2 22:01
 * @Version 1.0
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }


    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return res;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[][] digits_array = {
                {},  // 空的  补齐
                {},  // 空的  补齐
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        int len = digits.length();
        dfs(digits,len,0,stack,res,digits_array);
        return res;
    }

    private static void dfs(String digits, int len, int depth, Deque<Character> stack, List<String> res, char[][] digits_array) {
        if(len == depth){
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            res.add(sb.reverse().toString());
            return;
        }
        int num = digits.charAt(depth) - '0';  // 获取位置
        for (char c : digits_array[num]) {
            stack.push(c);
            dfs(digits,len,depth+1,stack,res,digits_array);
            stack.poll();
        }
    }


}
