
package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;
/**
 * AmountOfTimeForBinaryTreeToBeEffected
 */
public class AmountOfTimeForBinaryTreeToBeEffected {

    class BFSSolution {
        HashMap<Integer, List<Integer>> map;
        int totalNodes = 0;

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            totalNodes++;

            if (root.left != null) {
                if (!map.containsKey(root.val)) {
                    map.put(root.val, new ArrayList<>());
                }

                if (!map.containsKey(root.left.val)) {
                    map.put(root.left.val, new ArrayList<>());
                }

                map.get(root.val).add(root.left.val);
                map.get(root.left.val).add(root.val);
            }

            if (root.right != null) {
                if (!map.containsKey(root.val)) {
                    map.put(root.val, new ArrayList<>());
                }

                if (!map.containsKey(root.right.val)) {
                    map.put(root.right.val, new ArrayList<>());
                }

                map.get(root.val).add(root.right.val);
                map.get(root.right.val).add(root.val);
            }

            dfs(root.left);
            dfs(root.right);
        }

        public int amountOfTime(TreeNode root, int start) {
            map = new HashMap<>();
            dfs(root);

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.add(start);

            int count = 0;
            HashSet<Integer> seen = new HashSet<>();
            seen.add(start);
            int x = 1;

            if (totalNodes == 1)
                return 0;

            while (!dq.isEmpty()) {
                int n = dq.size();
                count++;

                for(int i = 0; i < n; i++) {
                    int t = dq.pollFirst();

                    for (int nei : map.getOrDefault(t, new ArrayList<>())) {
                        if (seen.contains(nei)) {
                            continue;
                        }

                        x++;
                        seen.add(nei);
                        dq.offerLast(nei);
                    }
                }

                if (x == totalNodes) {
                    return count;
                }

            }

            return count;
        }
    }

    // We don't create a new graph.
    class DFSSolution {
        int maxDist = 0;

        int dfs(TreeNode root, int start) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left, start);
            int right = dfs(root.right, start);

            if (root.val == start) {
                maxDist = Math.max(left, right);
                return -1;
            } else if (left >= 0 && right >= 0) {
                return Math.max(left, right) + 1;
            } else {
                int distance = Math.max(Math.abs(left), Math.abs(right));
                maxDist = Math.min(maxDist, distance) - 1;

                return Math.min(left, right) - 1;
            }
        }

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, start);
            return maxDist;
        }
    }
}
