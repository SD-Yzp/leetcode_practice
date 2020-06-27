package com.study.thought.dynamic_programming.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 单词拆分
 * @Author Yin
 * @Date 2020/6/8 16:32
 * @Version 1.0
 **/
public class WordBreak {
    public static void main(String[] args) {
        // String s = "leetcode";
        // String s = "applepenapple";
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        // wordDict.add("code");
        // wordDict.add("apple");
        // wordDict.add("pen");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak(s,wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int word_len = word.length();
                if(i >= word_len && word.equals(s.substring(i-word_len,i))){
                    f[i] = f[i] || f[i-word_len];
                }
            }
        }
        return f[len];
    }
}
