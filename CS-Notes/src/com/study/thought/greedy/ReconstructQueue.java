package com.study.thought.greedy;

import java.util.*;

/**
 * @Description 根据身高重建队列
 * @Author Yin
 * @Date 2020/5/30 15:25
 * @Version 1.0
 **/
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {
                /*{7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2},*/
                {9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}
        };
        int[][] res = reconstructQueue_better(people);
        for (int[] r : res) {
            for (int i : r) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0){
            return people;
        }
        int row = people.length;
        int[][] res = new int[row][2];
        for (int i = 0; i < row; i++) {
            res[i][0] = -1;
        }
        // 按照第二个位置大小逆序排列
        Arrays.sort(people,(o1, o2) -> o2[1] - o1[1]);
        // 存放已经找到的身高
        Set<Integer> set = new HashSet<>();
        int count = 0;
        // 结束条件，所有人排完队
        while (count<row){
            // 每次找到最矮的
            int minHeight = Integer.MAX_VALUE;
            for (int[] person : people) {
                if(!set.contains(person[0])){
                    minHeight = Math.min(person[0], minHeight);
                }
            }
            // 放入set
            set.add(minHeight);
            // 比较放入res
            for (int[] person : people) {
                if(minHeight==person[0]){
                    int position = person[1];
                    // 判断位置是否足够
                    int empty_count = position;
                    for (int i = 0; i < position; i++) {
                        // 位置有人,空位数量减一
                        if(res[i][0]!=-1){
                            empty_count--;
                        }
                    }
                    // 需要的空位
                    int d = position - empty_count;
                    // 通过差往后找空位  最后一个不用往后找
                    for (int i = position; i < row && d > 0 && count < row-1; i++) {
                        // 位置空着 d--
                        if(res[i][0]==-1){
                            d--;
                        }
                        position++;
                    }

                    // 判断位置是否有人
                    while(res[position][0]!=-1){   // 因为身高不为-1
                        // 有人就往后放
                        position++;
                    }
                    res[position][0] = person[0];
                    res[position][1] = person[1];
                    // 排完人计数
                    count++;
                }
            }
        }

        return res;
    }
    public static int[][] reconstructQueue_better(int[][] people) {
        if(people==null||people.length==0){
            return people;
        }
        // 排序  身高从大到小   身高相同,位置升序
        Arrays.sort(people,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }

        return list.toArray(new int[list.size()][]);
    }
}
