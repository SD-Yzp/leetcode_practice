package com.study.structure.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 包含重复元素
 * @Author Yin
 * @Date 2020/6/12 17:52
 * @Version 1.0
 **/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
