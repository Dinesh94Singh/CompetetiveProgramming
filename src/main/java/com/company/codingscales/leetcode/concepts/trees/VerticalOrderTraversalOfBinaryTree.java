package com.company.codingscales.leetcode.concepts.trees;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalOfBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
    static TreeMap<Integer, List<Pair<Integer, Integer>>> hm;

    private static void dfs(final TreeNode root, final int x, final int y) {
        if (root == null)
            return;

        hm.putIfAbsent(x, new ArrayList<>());
        hm.get(x).add(new Pair<Integer, Integer>(root.val, y)); // for sorting based on level

        dfs(root.left,x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(final TreeNode root) {
        hm = new TreeMap<>();
        final List<List<Integer>> res = new ArrayList<>();
        dfs(root,0, 0);
        for(final List<Pair<Integer, Integer>> values : hm.values()) {
            values.sort((x, y) -> {
                if (!x.getValue().equals(y.getValue()))
                    return x.getValue() - y.getValue();
                return x.getKey() - y.getKey();
            });
            final List<Integer> t = new ArrayList<>();
            for(final Pair<Integer, Integer> p : values) {
                t.add(p.getKey());
            }
            res.add(t);
        }
        return res;
    }
}
