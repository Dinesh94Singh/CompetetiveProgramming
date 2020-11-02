package com.company.codingscales.binarysearchio.concepts.graphs;

import java.util.Arrays;

// TODO: Do this for amazon interview
public class LondonBridge {
    // Find the critical edges in an network - tarjan's algorithm
    // Good reads - https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution
    // https://www.youtube.com/watch?v=RYaakWv5m6o
    int time = 0;
    int count = 0;
    /*
        graph input => graph[i] represents node i's neighbors.
     */
    public int solve(int[][] graph) {
        int n = graph.length;

        int[] num = new int[n];
        int[] low = new int[n];
        Arrays.fill(num, -1);
        Arrays.fill(low, 0);
        for (int i = 0; i < n; i++) {
            if (num[i] == -1) {
                dfs(i, low, num, graph, -1);
            }
        }
        return count;
    }
    public void dfs(int i, int[] low, int[] num, int[][] graph, int parent) {
        low[i] = num[i] = time++;
        for (int j : graph[i]) {
            if (j == parent)
                continue;
            if (num[j] == -1) {
                dfs(j, low, num, graph, i);
                low[i] = Math.min(low[i], low[j]);
                if (low[j] > num[i]) {
                    count++;
                }
            } else {
                low[i] = Math.min(low[i], num[j]);
            }
        }
    }
}
