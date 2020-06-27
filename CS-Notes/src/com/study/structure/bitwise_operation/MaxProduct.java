package com.study.structure.bitwise_operation;

/**
 * @Description 最大单词长度乘积
 * @Author Yin
 * @Date 2020/6/25 21:30
 * @Version 1.0
 **/
public class MaxProduct {
    public int maxProduct(String[] words) {
        int len = words.length;
        boolean[][] marked = new boolean[len][26];
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                int index = indexForChar(c);
                marked[i][index] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if(marked[i][k] && marked[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res = Math.max(words[i].length()*words[j].length(),res);
                }
            }
        }
        return res;
    }
    private int indexForChar(char c){
        return c - 'a';
    }

    public int maxProduct2(String[] words) {
        int len = words.length;
        int[] val = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if((val[i] & val[j]) == 0){
                    res = Math.max(words[i].length()*words[j].length(),res);
                }
            }
        }
        return res;
    }

}
