package com.company.codingscales.interviews.goldmansachs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// TODO: Do again => Placeholder to understand the LC Solution better
// https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)
public class SkylineProblem {
    public List<List<Integer>> getSkyLine(int[][] B) {
        List<int[]> al = new ArrayList<>();
        for(int[] b : B) {
            al.add(new int[]{b[0], -b[2]});
            al.add(new int[]{b[1], b[2]});
        }

        Collections.sort(al, (a, b) -> { // sort based on Start-Point
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> history = new PriorityQueue<>(Collections.reverseOrder());
        history.offer(0);
        int prevHeight = 0;

        List<List<Integer>> res = new ArrayList<>();
        for(int[] b : al) {
            if (b[1] < 0) { // starting point, so add to history
                history.offer(-b[1]);
            } else { // the building ended, remove the buildings from the list of tall buildings
                history.remove(b[1]); // O(NLogN) operation
            }

            int curr = history.peek();
            if (curr != prevHeight) { // if both are same, then, the skyline continues, until it finds a tall / shorter building
                List<Integer> t = new ArrayList<>();
                t.add(b[0]);
                t.add(curr);
                res.add(t);
                prevHeight = curr;
            }
        }

        return res; // total tc - O(N^2)
    }
}
