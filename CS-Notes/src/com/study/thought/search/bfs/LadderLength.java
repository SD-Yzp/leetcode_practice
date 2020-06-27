package com.study.thought.search.bfs;

import java.util.*;

/**
 * @Description 单词接龙
 * @Author Yin
 * @Date 2020/6/2 15:18
 * @Version 1.0
 **/
public class LadderLength {
    public static void main(String[] args) {
        String s1 = "hot";
        String s2 = "dog";
        // String[] words = {"hot","dot","dog","lot","log","hit"};
        String[] words = {"hot","dog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(ladderLength(s1,s2,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        // 看一遍是否存在
        boolean isExist = false;
        for (String s : wordList) {
            if (endWord.equals(s)) {  // endWord非空
                isExist = true;
                break;
            }
        }
        // 不存在直接返回
        if(!isExist){
            return 0;
        }
        // 记录是否走过
        boolean[] marked = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            while(size-- > 0){
                String temp = queue.poll();
                if(endWord.equals(temp)){
                    return res;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if(!marked[i] && isNext(temp,wordList.get(i))){
                        queue.offer(wordList.get(i));
                        marked[i] = true;
                    }
                }
            }
        }

        return 0;
    }

    /**
     * 判断两个单词是否只差一个字母（顺序一致）
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isNext(String s1,String s2){
        int count = 0;
        for (int i = 0; i < s2.length() && count <= 1; i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
}
