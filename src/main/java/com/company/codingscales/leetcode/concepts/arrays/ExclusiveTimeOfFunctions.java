package com.company.codingscales.leetcode.concepts.arrays;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    // Input is always valid, means, process will end for sure
    // When ever the process is ending, it would be the process which is under progress.
    public static int[] exclusiveTime(int n, List<String> logs) {
        final Stack<Integer> st = new Stack<>();

        final int[] res = new int[n];
        int prevTime = 0;
        for(final String e : logs) {
            final String[] A = e.split(":");
            final int processId = Integer.parseInt(A[0]);
            final String type = A[1];
            final int curTime = Integer.parseInt(A[2]);

            // System.out.println("prev time " + " curr Time " + prevTime + " : " + curTime);

            if (type.equals("start")) { // prev process, which even in execution halts
                if (!st.isEmpty()) {
                    final int prevProcess = st.peek();
                    res[prevProcess] += curTime - prevTime - 1;
                }
                st.push(processId); // new Process will take action now
                prevTime = curTime;
            } else {
                // what ever is in progress, ended ? yes
                final int prevProcess = st.pop();
                res[prevProcess] += curTime - prevTime + 1;
                prevTime = curTime;
            }
        }

        return res;
    }
}
