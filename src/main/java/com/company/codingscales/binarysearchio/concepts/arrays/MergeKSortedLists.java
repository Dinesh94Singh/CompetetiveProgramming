package com.company.codingscales.binarysearchio.concepts.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public int[] solve(int[][] lists) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((e1, e2) -> lists[e1[0]][e1[1]] - lists[e2[0]][e2[1]]);

        for(int i = 0; i < lists.length; i++) {
            if (lists[i].length == 0)
                continue;
            pq.offer(new int[]{i, 0});
        }

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            res.add(lists[p[0]][p[1]]);

            if (p[1] + 1 == lists[p[0]].length) {
                // do nothing here
            } else {
                pq.add(new int[]{p[0], p[1] + 1});
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }

        return ret;
    }
}
