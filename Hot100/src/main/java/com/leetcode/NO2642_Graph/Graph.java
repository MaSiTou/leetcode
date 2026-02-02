package com.leetcode.NO2642_Graph;

import java.util.Arrays;

class Graph {
    int[][] dist;
    int N;
    /**
     * 首先使用佛洛依德算法进行初始化
     * @param n
     * @param edges
     */
    public Graph(int n, int[][] edges) {
        dist = new int[n][n];
        N = n;
        for(int i = 0;i < n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i = 0;i < edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int cost = edges[i][2];
            dist[from][to] = cost;
        }
        for(int k = 0;k < n;k++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    if (i == j || dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int NowFromNode = edge[0];
        int NowToNode = edge[1];
        if (NowFromNode == NowToNode){
            return;
        }
        int NodeCost = edge[2];
        dist[NowFromNode][NowToNode] = Math.min(dist[NowFromNode][NowToNode],NodeCost);
        for(int i = 0;i < N;i++){
            if (i == NowFromNode || dist[NowFromNode][i] == Integer.MAX_VALUE || dist[i][NowToNode] == Integer.MAX_VALUE){
                continue;
            }
            dist[NowFromNode][NowToNode] =  Math.min(dist[NowFromNode][i] + dist[i][NowToNode],dist[NowFromNode][NowToNode]);
        }
        for(int i = 0;i < N;i++){
            if (dist[i][NowFromNode] == Integer.MAX_VALUE && i != NowFromNode){
                continue;
            }
            for(int j = 0;j < N;j++){
                if (dist[NowToNode][j] == Integer.MAX_VALUE && NowToNode != j){
                    continue;
                }
                if (i == NowFromNode && j != NowToNode){
                    dist[i][j] = Math.min(dist[i][j],dist[NowFromNode][NowToNode]+dist[NowToNode][j]);
                }else if (i != NowFromNode && j == NowToNode){
                    dist[i][j] = Math.min(dist[i][j],dist[i][NowFromNode]+dist[NowFromNode][NowToNode]);
                }else if (i != NowFromNode && j != NowToNode){
                    dist[i][j] = Math.min(dist[i][j],dist[i][NowFromNode]+dist[NowFromNode][NowToNode]+dist[NowToNode][j]);
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        System.out.println("node1:" + node1 + " " + node2);
        for(int i =0;i < N;i++){
            for(int j = 0;j < N;j++){
                if (dist[i][j] != Integer.MAX_VALUE){
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
        if (node1 == node2){
            return 0;
        }
        if (dist[node1][node2] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[node1][node2];
    }
}