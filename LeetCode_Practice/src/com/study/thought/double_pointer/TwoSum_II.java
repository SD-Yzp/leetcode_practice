package com.study.thought.double_pointer;

/**
 * @Description 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * @Author Yin
 * @Date 2020/5/28 15:19
 * @Version 1.0
 **/
public class TwoSum_II {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length==0){
            return null;
        }
        // 存放结果
        int[] res = new int[2];
        // 数组长度
        int len = numbers.length;
        // 双指针
        int start = 0;
        int end = len-1;
        // 因为一个数不能用两次，相交结束
        while(start<end){
            // 得到结果，返回下标加一（要求返回值不是从0开始）
            if(numbers[start]+numbers[end]==target){
                res[0] = start+1;
                res[1] = end+1;
                return res;
            }else if(numbers[start]+numbers[end]>target){
                // 相交大于结果，尾指针往前走
                end--;
            }else {
                // 相交小于结果，头指针往前走
                start++;
            }
        }

        // 没有找到结果
        return null;
    }
}
