package com.company.codingscales.leetcode.concepts.trees;

import javafx.util.Pair;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    static class Tuple {
        int x, y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    TreeMap<Integer, List<Tuple>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        for(Map.Entry<Integer, List<Tuple>> entry : map.entrySet()) {
            List<Tuple> l = entry.getValue();

            l.sort((a, b) -> {
                if (a.y == b.y) {
                    return a.val - b.val;
                }

                return a.y - b.y;
            });

            res.add(new ArrayList<>());
            for(Tuple t : l)
                res.get(res.size()-1).add(t.val);
        }

        return res;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null)
            return;

        Tuple t = new Tuple(x, y, root.val);

        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(t);

        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversalWithoutSorting(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        // Pair of node and its column offset
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }

        return output;
    }
}
