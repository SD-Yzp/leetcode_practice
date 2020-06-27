package com.study.thought.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Different Ways to Add Parentheses
 * @Author Yin
 * @Date 2020/6/1 16:36
 * @Version 1.0
 **/
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String input){
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c){
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(ways.size()==0){
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
