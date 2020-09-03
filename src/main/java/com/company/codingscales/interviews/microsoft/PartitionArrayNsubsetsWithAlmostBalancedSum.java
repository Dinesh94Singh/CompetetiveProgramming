package com.company.codingscales.interviews.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PartitionArrayNsubsetsWithAlmostBalancedSum {
    private static List<List<Integer>> solve(final int[] arr, final int totalNoOfSubsets) {
        final int[] sums = new int[totalNoOfSubsets];
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(curr -> sums[curr]));
        final PriorityQueue<Integer> pq = new PriorityQueue<>((curr, other) -> {
            return sums[curr] - sums[other];
        });

        final List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < totalNoOfSubsets; i++) {
            res.add(new ArrayList<>());
            pq.add(i);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            final int c = pq.poll();
            res.get(c).add(arr[i]);
            sums[c] += arr[i];
            pq.add(c);
        }

        return res;
    }

    private static List<List<Integer>> backtrackingSol(final int[] arr, final int totalNoOfSubsets) {
        int target = 0;
        for(final int a: arr) {
            target += a;
        }

        target = target / arr.length;
        final List<List<Integer>> res = new ArrayList<>();
        final int[] visited = new int[arr.length];
        backtrack(res, new ArrayList<>(),0,arr,target, visited);
        return res;
    }

    private static void backtrack(final List<List<Integer>> res, final List<Integer> subset, final int index, final int[] arr, final int target, final int[] visited) {
        if (target == 0)
            res.add(new ArrayList<>(subset)); // subset is mutable, so create an new list
        else if (target < 0)
            return;
        for(int i = index; i < arr.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                subset.add(arr[i]);
                backtrack(res, subset, i + 1, arr,target - arr[i], visited);
                subset.remove(subset.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(final String[] args) {
        System.out.println(solve(new int[] {1, 2, 3, 4, 5}, 3));
        System.out.println(solve(new int[] {2, 9, 9, 10, 10}, 2));

        System.out.println(backtrackingSol(new int[] {1, 2, 3, 4, 5}, 3));
        System.out.println(backtrackingSol(new int[] {2, 9, 9, 10, 10}, 2));
    }
}
