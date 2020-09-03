package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

// https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {
    private int recHelper(final int end, final HashMap<Integer, Integer> cache) {
        if (end <= 1) { return 1; }
        if (cache.containsKey(end)) { return cache.get(end); }
        int left, right, count = 0;
        for (int i = 1; i < end; i ++) {
            left = recHelper(i - 1, cache);
            right = recHelper(end - i, cache);

            count += left * right;
        }
        cache.put(end, count);
        return cache.get(end);
    }

    public int numTreesRecursive(final int n) {
        if (n == 0) {
            return 0;
        }
        final HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        recHelper(n, cache);
        return cache.get(n);
    }

    public int numTreesDP(final int n) {
        final int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(final String[] args) {
        final UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTreesRecursive(3));
    }
}
