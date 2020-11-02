package com.company.codingscales.binarysearchio.concepts.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TopLevelOfTree {
    static class Pair {
        Tree node;
        int x;

        Pair(Tree node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public int[] solve(Tree root) {
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        HashMap<Integer, Integer> columns = new HashMap<>();
        dq.add(new Pair(root, 0));

        while (!dq.isEmpty()) {
            int N = dq.size();

            for(int i = 0; i < N; i++) {
                Pair p = dq.pollFirst();

                if (!columns.containsKey(p.x)) {
                    columns.put(p.x, p.node.val);
                }

                Tree n = p.node;
                int x = p.x;
                if (n.left != null) {
                    dq.offerLast(new Pair(n.left, x - 1));
                }

                if (n.right != null) {
                    dq.offerLast(new Pair(n.right, x + 1));
                }
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(columns.keySet());
        Collections.sort(keys);

        int[] res = new int[keys.size()];
        int k = 0;
        for(Integer key : keys) {
            res[k++] = columns.get(key);
        }

        return res;
    }
}
