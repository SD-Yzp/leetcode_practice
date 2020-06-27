package com.study.thought.sort;

/**
 * @Description 使用堆排序找到第K大的数
 * @Author Yin
 * @Date 2020/5/29 16:40
 * @Version 1.0
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        /*int[] arr = new int[] {9,6,8,7,0,1,10,4,2};
        new FindKthLargest().heapSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public int findKthLargest(int[] nums,int k){
        heapSort(nums);
        return nums[nums.length-k];
    }

    public void heapSort(int[] nums){
        int size = nums.length;
        int temp = (size-1)/2;
        for (int i = temp; i >= 0; i--) {
            maxHeap(nums,size,i);
        }

        for (int i = size-1; i >= 0; i--) {
            swap(nums,0,i);
            maxHeap(nums,i,0);
        }
    }

    public void maxHeap(int[] nums,int size,int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int maxIndex = index;
        if(left<size&&nums[left]>nums[maxIndex]){
            maxIndex = left;
        }
        if(right<size&&nums[right]>nums[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex != index){
            swap(nums,index,left);
            maxHeap(nums,size,maxIndex);
        }
    }

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
