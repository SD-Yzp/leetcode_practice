package com.study.thought.double_pointer;

import java.util.*;

/**
 * @Description 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * @Author Yin
 * @Date 2020/5/28 20:51
 * @Version 1.0
 **/
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "bab";
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
        System.out.println(findLongestWord(s,d));
    }
    public static String findLongestWord(String s, List<String> d) {
        if(s==null||s.length()==0||d==null||d.isEmpty()){
            return "";
        }
        int maxLen = 0;
        String res = "";
        List<String> list = new ArrayList<>();
        for (String str : d) {
            if (maxLen < str.length()) {
                if (isMatching(s, str)) {
                    maxLen = str.length();
                    list.clear();
                    list.add(str);
                }
            }else if(maxLen == str.length()){
                if (isMatching(s, str)){
                    list.add(str);
                }
            }
        }
        if(!list.isEmpty()){
            list.sort(String::compareTo);
            res = list.get(0);
        }


        return res;
    }

    public static boolean isMatching(String s,String str){
        int len1 = s.length();
        int len2 = str.length();
        int p1 = 0;
        int p2 = 0;
        while(p1<len1&&p2<len2){
            if(s.charAt(p1)==str.charAt(p2)){
                p2++;
            }
            p1++;
        }
        // p2是否匹配到头
        return p2==len2;
    }
}
