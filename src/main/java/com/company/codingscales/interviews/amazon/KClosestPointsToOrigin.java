package com.company.codingscales.interviews.amazon;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Tuple {
        int x;
        int y;
        int dist;

        Tuple(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        // TODO: No need to Tuple, can create int[] and hard code to write comparator with a[2]
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for(int[] point : points) {
            queue.add(new Tuple(point[0], point[1], distance(point)));
        }
        int index = 0;
        while(index < K) {
            Tuple t = queue.poll();
            result[index][0] = t.x;
            result[index][1] = t.y;
            index++;
        }

        return result;
    }

    public int distance(int[] point) {
        return point[0]*point[0] + point[1] * point[1];
    }
}
