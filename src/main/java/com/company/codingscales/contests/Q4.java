package com.company.codingscales.contests;

import java.util.*;

public class Q4 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    void dfs(int x, TreeNode root, TreeMap<Integer, List<Integer>> ts) {
        if (root == null)
            return;

        ts.putIfAbsent(x, new ArrayList<>());
        ts.get(x).add(root.val);

        dfs(x - 1, root, ts);
        dfs(x + 1, root, ts);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> ts = new TreeMap<>();
        dfs(0, root, ts);

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : ts.values()) {
            res.addAll(Collections.singleton(l));
        }

        return res;
    }

    public static void main(String[] args) {
    }
}
