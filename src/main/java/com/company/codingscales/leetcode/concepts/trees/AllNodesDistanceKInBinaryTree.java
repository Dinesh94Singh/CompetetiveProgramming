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

    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceKNoExtraSpace(TreeNode r, TreeNode t, int k) {
        dfs2(r, t, k, 0);
        return ans;
    }
    // combines the above 2 rec fns
    private int dfs2(TreeNode r, TreeNode t, int k, int length) {
        if (r == null)
            return 0;

        if (length == k) {
            ans.add(r.val);
            return 0;
        }

        int t1, t2;

        if (r.val == t.val || length > 0) {
            t1 = dfs2(r.left, t, k, length + 1); // add all left sub-tree
            t2 = dfs2(r.right, t, k, length + 1); // add all right sub-tree
        } else {
            t1 = dfs2(r.left, t, k, length); // when child tree has the target, t1 becomes +ve
            t2 = dfs2(r.right, t, k, length); // when child tree has the target, t2 becomes +ve
        }

        if (r.val == t.val)
            return 1;

        if (t1 > 0) { // from left child tree, we are t1 distance apart
            dfs2(r.right, t, k, t1 + 1);
            return t1 + 1;
        }

        if (t2 > 0) { // from right child tree, we are t2 distance apart
            dfs2(r.left, t, k, t2 + 1);
            return t2 + 1;
        }

        return 0;
    }
}
