package com.leetcode.NO3650_minCost;


import java.util.*;

/**
 * 深度优先遍历，同时记录已经遍历过的，目前为止最小的路径
 * 使用Map<Integer,Map<Integer,Integer></>>来存
 */

/**
 * 这种方法不行，超时，需要使用迪杰斯特拉算法
 * 单元最短路径问题，从起点到各个点的最短距离
 */
class Solution {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] map = new List[n];
        Arrays.setAll(map,k->new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int nowNode = edges[i][0];
            int nextNode = edges[i][1];
            int price = edges[i][2];
            map[nowNode].add(new int[]{nextNode,price});
            map[nextNode].add(new int[]{nowNode,2*price});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.add(new int[]{0,0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();

            if (poll[0] > dist[poll[1]]){
                continue;
            }
            if (poll[1] == n-1){
                return poll[0];
            }
            for(int[] next:map[poll[1]]){
                int newPrice = next[1] + poll[0];
                if (newPrice < dist[next[0]]){
                    dist[next[0]] = newPrice;
                    pq.add(new int[]{newPrice,next[0]});
                }
            }
        }
        return -1;
    }
}