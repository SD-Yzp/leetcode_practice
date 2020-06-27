package com.study.thought.greedy;

/**
 * @Description 非递减数列
 * @Author Yin
 * @Date 2020/5/30 18:38
 * @Version 1.0
 **/
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = {1,2,5,3,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1||nums.length==2){
            return true;
        }
        int len = nums.length;
        int position = -1;
        int count = 0;
        for (int i = 0; i < len-1; i++) {
            if(nums[i]>nums[i+1]){
                position = i;
                count++;
                if(count==2){
                    return false;
                }
                if(i==len-2){
                    break;
                }
                i++;
            }
        }


        // 边界情况
        if(position==-1||(position==0 && nums[position + 1] <= nums[position + 2])||position==len-2){
            return true;
        }else {
            if(nums[position+2]>=nums[position]){
                return true;
            }else return nums[position + 1] <= nums[position + 2] && nums[position+1] >= nums[position - 1];
        }

    }
}
