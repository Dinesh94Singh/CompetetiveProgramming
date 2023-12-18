package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;
import javafx.util.*;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    HashSet<Integer> seen;
    HashMap<Integer, List<Pair<TreeNode, String>>> graph;
    String res = null;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        graph = new HashMap<>();
        seen = new HashSet<>();

        dfs(root);

        construct(startValue, destValue, new StringBuilder());
        return res;
    }

    private void construct(int curr, int dest, StringBuilder sb) {
        if (seen.contains(curr)) {
            return;
        }

        seen.add(curr);

        if (curr == dest) {
            res = sb.toString();
            return;
        }

        for (Pair<TreeNode, String> p : graph.getOrDefault(curr, new ArrayList<>())) {
            sb.append(p.getValue());
            construct(p.getKey().val, dest, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        graph.putIfAbsent(root.val, new ArrayList<>());

        if (root.left != null) {
            graph.putIfAbsent(root.left.val, new ArrayList<>());

            graph.get(root.left.val).add(new Pair<>(root, "U"));
            graph.get(root.val).add(new Pair<>(root.left, "L"));
        }

        if (root.right != null) {
            graph.putIfAbsent(root.right.val, new ArrayList<>());

            graph.get(root.right.val).add(new Pair<>(root, "U"));
            graph.get(root.val).add(new Pair<>(root.right, "R"));
        }

        dfs(root.left);
        dfs(root.right);
    }
}
