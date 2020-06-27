package com.study.thought.dichotomy;

/**
 * @Description 第一个错误的版本
 * @Author Yin
 * @Date 2020/5/31 18:58
 * @Version 1.0
 **/
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }

    public static int firstBadVersion(int n) {
        // 处理边界条件
        if(isBadVersion(1)){
            return 1;
        }
        int l = 1;
        int r = n;
        int mid;
        while(l<=r){
            mid = l + (r - l)/2;
            if(!isBadVersion(mid)){
                l = mid + 1;
            }else{
                if(isBadVersion(mid-1)){
                    r = mid - 1;
                }else {
                    return mid;
                }
            }
        }

        return -1;
    }

    private static boolean isBadVersion(int version){
        return version >= 2;
    }
}
