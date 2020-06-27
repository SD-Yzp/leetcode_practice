package com.study.thought.double_pointer;

/**
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Author Yin
 * @Date 2020/5/28 16:26
 * @Version 1.0
 **/
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip";
        System.out.println(validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        // 转成字符数组
        char[] chars = s.toCharArray();
        // 可能的位置
        int position = 0;
        // 是否可以回去
        boolean flag = false;
        // 双指针
        int start = 0;
        int end = chars.length-1;
        // 出错次数
        int count = 0;
        while(start<end){
            // 回文判断 不是回文或者到中间就跳出
            while(start<end&&chars[start]==chars[end]){
                start++;
                end--;
            }
            if(start>=end) {
                return true;
            }
            count++;
            // 三次错误以上直接返回
            if(count>=3){
                return false;
            }
            // 两次错误
            if(count==2){
                 // 不可以回头，直接返回
                 if(!flag){
                     return false;
                 // 可以回头，回到记录位置
                 }else{
                     end = chars.length-1-position;
                     start = position+1;
                     flag = false;
                 }
            }
            // 只有第一次出现错误才会判断是否回头
            if(count==1){
                // 删后边删前边都可以
                if(chars[end-1]==chars[start]&&chars[end]==chars[start+1]){
                    position = start;
                    // 可以回头
                    flag = true;
                    end--;
                // 只能删一边，不可以回头
                }else{
                    if(chars[end-1]==chars[start]){
                        end--;
                    }else if(chars[end]==chars[start+1]){
                        start++;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
