package com.study.thought.dichotomy;

/**
 * @Description 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * @Author Yin
 * @Date 2020/5/31 17:43
 * @Version 1.0
 **/
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'e', 'e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter(letters,'e'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length-1;
        int mid;
        if(target < letters[l] || target >= letters[r]){
            return letters[l];
        }
        // 再这样的循环条件下 l最后总是比r大一，所以我们要考虑的就是最后要选大的还是选小的
        while(l <= r){
            mid = l + (r - l)/2;
            if(target >= letters[mid]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return letters[l];
    }
}
