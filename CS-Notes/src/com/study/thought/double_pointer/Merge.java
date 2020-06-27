package com.study.thought.double_pointer;

/**
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *                  - 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *                  - 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * @Author Yin
 * @Date 2020/5/28 18:34
 * @Version 1.0
 **/
public class Merge {

    /**
     * 使用三指针
     * @param nums1
     * @param m     nums1中元素数量
     * @param nums2
     * @param n     nums2中元素数量
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 记录nums1的位置
        int a = m-1;
        // 记录nums2的位置
        int b = n-1;
        // 记录尾
        int end = m+n-1;
        while(a>=0&&b>=0){
            nums1[end--] = nums1[a] > nums2[b] ? nums1[a--] : nums2[b--];
        }
        while(b>=0){
            nums1[end--] = nums2[b--];
        }
    }
}
