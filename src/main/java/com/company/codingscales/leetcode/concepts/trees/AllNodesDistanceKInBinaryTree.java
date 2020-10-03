package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    Set<Integer> res;

    void dfs(final TreeNode root, final TreeNode parent, final HashMap<TreeNode, List<TreeNode>> graph) {
        if (root == null) { return; }

        graph.putIfAbsent(root, new ArrayList<>());
        if (parent != null) {
            graph.get(root).add(parent);
        }
        if (root.left != null)
            graph.get(root).add(root.left);
        if (root.right != null)
            graph.get(root).add(root.right);

        dfs(root.left, root, graph);
        dfs(root.right, root, graph);
    }

    void reach(final HashMap<TreeNode, List<TreeNode>> graph, HashSet<TreeNode> visited, final TreeNode root, final int k) {
        if (k == 0) {
            res.add(root.val);
            return;
        }

        visited.add(root);

        for(final TreeNode each : graph.getOrDefault(root, new ArrayList<>())) {
            if (!visited.contains(each))
                reach(graph, visited, each, k - 1);
        }

        visited.remove(root);
    }

    public List<Integer> distanceK(final TreeNode root, final TreeNode target, final int K) {
        final HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        res = new HashSet<>();
        dfs(root, null, graph);
        reach(graph, new HashSet<TreeNode>(), target, K);

        return new ArrayList<>(res);
    }
}
