package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

class HeightOfABinaryTreeAfterSubtreeRemovalQueries {

    HashMap<Integer, Integer> depth = new HashMap<>();
    HashMap<Integer, Integer> height = new HashMap<>();

    private int dfs(TreeNode root, int level) {
        if (root == null) {
            return -1;
        }

        depth.put(root.val, level);

        int left = dfs(root.left, level + 1);
        int right = dfs(root.right, level + 1);

        height.put(root.val, Math.max(left, right) + 1);
        return Math.max(left, right) + 1;
    }


    public int[] treeQueries(TreeNode root, int[] queries) {
        // find the depth, height of the tree nodes - store in HashMap
        dfs(root, 0);

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : depth.entrySet()) {
            int node = entry.getKey();
            int level = entry.getValue();

            if (!map.containsKey(level)) {
                map.put(level, new PriorityQueue<>((a, b) -> height.get(a) - height.get(b)));
            }

            map.get(level).offer(node);
            if (map.get(level).size() > 2) {
                map.get(level).poll();
            }
        }

        int[] res = new int[queries.length];
        int i = 0;
        for(int q : queries) {
            int d = depth.get(q);

            PriorityQueue<Integer> pq = map.get(d);
            if (pq.size() == 1) {
                res[i] = d - 1;
            } else if (pq.peek() == q) {
                // then we are not deleting the longest one
                int first = pq.poll();
                int second = pq.poll();

                res[i] = d + height.get(second);
                pq.offer(first);
                pq.offer(second);
            } else {
                // we are deleting the longest one
                int first = pq.poll();

                if (pq.peek() == q) {
                    // If we are deleting the largest one
                    res[i] = d + height.get(first);
                    pq.offer(first);
                } else {
                    int second = pq.poll();

                    res[i] = d + height.get(second);
                    pq.offer(first);
                    pq.offer(second);
                }
            }

            i++;
        }

        return res;
    }
}
