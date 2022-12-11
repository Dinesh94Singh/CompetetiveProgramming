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

    // Solves with duplicates
    public List<Integer> distanceK(final TreeNode root, final TreeNode target, final int K) {
        final HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        res = new HashSet<>();
        dfs(root, null, graph);
        reach(graph, new HashSet<TreeNode>(), target, K);

        return new ArrayList<>(res);
    }

    // Use these solutions in interview
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> al = new ArrayList<>();

    public List<Integer> distanceKUsingMap(TreeNode root, TreeNode target, int k) {
        find(root, target);
        if (map.isEmpty())
            return new ArrayList<>();

        dfs(root, target, k, map.get(root.val));
        return al;
    }

    private int find(TreeNode r, TreeNode t) {
        if (r == null)
            return -1;
        if (r.val == t.val) {
            map.put(r.val, 0);
            return 0;
        }

        int l = find(r.left, t);
        int ri = find(r.right, t);

        if (l >= 0) {
            map.put(r.val, l + 1);
            return l + 1;
        }

        if (ri >= 0) {
            map.put(r.val, ri + 1);
            return ri + 1;
        }

        return -1;
    }

    private void dfs(TreeNode r, TreeNode t, int k, Integer length) {
        if (r == null)
            return;

        if (map.containsKey(r.val))
            length = map.get(r.val); // target in sub-tree


        if (length == k) {
            al.add(r.val);
        }


        dfs(r.left, t, k, length + 1);
        dfs(r.right, t, k, length + 1);
    }

    class AnotherSolution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new LinkedList<>();
            if (K == 0) {
                res.add(target.val);
            } else {
                dfs(res, root, target.val, K ,0);
            }
            return res;
        }

        private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
            if (node == null) return 0;

            if (depth == K) {
                res.add(node.val);
                return 0;
            }

            int left, right;
            if (node.val == target || depth > 0) {
                left = dfs(res, node.left, target, K, depth + 1);
                right = dfs(res, node.right, target, K, depth + 1);
            } else {
                left = dfs(res, node.left, target, K, depth);
                right = dfs(res, node.right, target, K, depth);
            }

            if (node.val == target) return 1;

            if (left == K || right == K) {
                res.add(node.val);
                return 0;
            }

            if (left > 0) {
                dfs(res, node.right, target, K, left + 1);
                return left + 1;
            }

            if (right > 0) {
                dfs(res, node.left, target, K, right + 1);
                return right + 1;
            }

            return 0;
        }
    }
}
