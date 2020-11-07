package com.company.codingscales.interviews.amazon;

import java.util.PriorityQueue;

public class FillTheTruck {
    int solve(int n, int[] boxes, int unitSize, int[] unitPerBox, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1[0] != e2[0])
                return Integer.compare(e1[0], e2[0]);
            return Integer.compare(e1[1], e2[1]);
        });
        for(int i = 0; i < n; i++)
            pq.offer(new int[]{unitPerBox[i], boxes[i]});

        int ans = 0;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int unit = t[0];
            int boxSize = t[1];

            if (boxSize > truckSize) {
                ans += unit * truckSize;
                break;
            }

            ans += unit * boxSize;
            truckSize -= boxSize;
        }

        return ans;
    }
}
