package com.study.thought.math;

/**
 * @Description 多数元素
 * @Author Yin
 * @Date 2020/6/10 20:44
 * @Version 1.0
 **/
public class MajorityElement {
    /**
     * Boyer-Moore Majority Vote Algorithm
     *      使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2，因为如果多于 i / 2 的话 cnt 就一定不会为 0。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        int count = 0;
        int res = nums[0];
        for (int num : nums) {
            res = (count==0) ? num : res;
            count = (res==num) ? count+1 : count-1;
        }
        return res;
    }
}
