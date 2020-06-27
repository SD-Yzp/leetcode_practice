package com.study.structure.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 有效的括号
 * @Author Yin
 * @Date 2020/6/15 17:39
 * @Version 1.0
 **/
public class IsValid {
    public static void main(String[] args) {
        /*System.out.println(']'-0);
        System.out.println(')'-0);
        System.out.println('}'-0);*/
        String s = "((){})";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index)==')'||s.charAt(index)==']'||s.charAt(index)=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                int temp = s.charAt(index) - c;
                if(temp!=1&&temp!=2){
                    return false;
                }
            }else{
                stack.push(s.charAt(index));
            }
            index++;
        }
        return stack.isEmpty();
    }
}
