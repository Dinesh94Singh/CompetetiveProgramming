package com.company.codingscales.leetcode.concepts.arrays;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    // Input is always valid, means, process will end for sure
    // When ever the process is ending, it would be the process which is under progress.
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];


        Stack<Integer> st = new Stack<>(); // processId stack
        int prevTime = 0;

        for(String e : logs) {
            String[] A = e.split(":");

            int processId = Integer.parseInt(A[0]);
            String type = A[1];
            int time = Integer.parseInt(A[2]);

            if (type.equals("start")) {
                if (!st.isEmpty()) {
                    int prevId = st.peek(); // y peek?
                    res[prevId] += (time - prevTime - 1 + 1); // exclusive here
                    // at time t - new process already started, which means, prevProcess ended at time t - 1
                }
                prevTime = time;
                st.push(processId);
            } else {
                int prevId = st.pop(); // prevId == processId
                res[prevId] += (time - prevTime + 1); // here inclusive
                prevTime = time + 1; // we already consumed time -> so instead, we + 1 for next
            }
        }

        return res;
    }
}
