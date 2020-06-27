package com.study.thought.greedy;

import java.util.Arrays;

/**
 * @Description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 *              但是，每个孩子最多只能给一块饼干。
 *              对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 *              如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 *              你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * @Author Yin
 * @Date 2020/5/29 20:44
 * @Version 1.0
 **/
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g,s));
    }

    /**
     * 把最大的饼干先满足最贪心的小朋友
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = g.length-1;
        int p2 = s.length-1;
        while(p1>=0&&p2>=0){
            if(s[p2]>=g[p1]){
                p2--;
                res++;
            }
            p1--;
        }

        return res;
    }
}
