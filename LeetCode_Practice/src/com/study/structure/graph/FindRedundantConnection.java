package com.study.structure.graph;

/**
 * @Description 冗余连接
 * @Author Yin
 * @Date 2020/6/24 20:30
 * @Version 1.0
 **/
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            if (uf.connect(u,v)){
                return e;
            }
            uf.union(u,v);
        }
        return new int[]{-1,-1};
    }
    private class UF{
        private int[] id;

        UF(int N){
            id = new int[N+1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        void union(int u,int v){
            int uID = find(u);
            int vID = find(v);
            if(uID == vID){
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if(id[i] == uID){
                    id[i] = vID;
                }
            }
        }

        int find(int p) {
            return id[p];
        }

        boolean connect(int u,int v){
            return find(u) == find(v);
        }
    }
}
