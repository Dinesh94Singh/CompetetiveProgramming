package com.company.codingscales.interviews.amazon;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Point {
        int x;
        int y;
        int distance;

        Point(int[] p) {
            this.x = p[0];
            this.y = p[1];
            this.distance = getDistance(x, y);
        }
    }

    static int getDistance(int x, int y) {
        return (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);


        for(int[] e : points) {
            if (pq.size() < k) {
                pq.offer(new Point(e));
            } else {
                Point p = pq.peek();
                if (p.distance > getDistance(e[0], e[1])) {
                    pq.poll();
                    pq.offer(new Point(e));
                }
            }
        }

        int[][] res = new int[pq.size()][2];
        int t = 0;
        for(Point p : pq) {
            res[t][0] = p.x;
            res[t][1] = p.y;

            t++;
        }

        return res;
    }
}
