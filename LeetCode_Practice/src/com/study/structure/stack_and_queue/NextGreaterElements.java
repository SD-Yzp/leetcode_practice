package com.study.structure.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description 下一个更大的元素 II
 * @Author Yin
 * @Date 2020/6/15 20:21
 * @Version 1.0
 **/
public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,1};
        int[] res = nextGreaterElements_better(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0){
            return nums;
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            while(count < len){
                int temp = i+count+1;
                if(temp>=len){
                    temp -= len;
                }
                if(nums[i] < nums[temp]){
                    res[i] = nums[temp];
                    break;
                }
                if(nums[i]==nums[temp] && res[temp]!=0){
                    res[i] = res[temp];
                    break;
                }
                count++;
            }
            if(count==len){
                res[i] = -1;
            }
        }
        return res;
    }


    public static int[] nextGreaterElements_better(int[] nums){
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2*len; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && num>nums[stack.peek()]){
                int index = stack.pop();
                res[index] = num;
            }
            if(i < len){
                stack.push(i);
            }
        }
        return res;
    }
}
