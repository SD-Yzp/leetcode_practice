package com.study.structure.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 判断是否为二分图
 * @Author Yin
 * @Date 2020/6/24 17:11
 * @Version 1.0
 **/
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for (int i = 0; i < graph.length; i++) {
            if(colors[i] == -1 && !isBipartite(i,0,colors,graph)){
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if(colors[curNode] != -1){
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if(!isBipartite(nextNode,1-curColor,colors,graph)){
                return false;
            }
        }
        return true;
    }
}
