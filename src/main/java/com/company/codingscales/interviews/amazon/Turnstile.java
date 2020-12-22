package com.company.codingscales.interviews.amazon;

import java.util.LinkedList;

public class Turnstile {
    public static int[] turnsTileFunction(int[] time, int[] direction) {
        int n = time.length;
        int[] res = new int[n];

        LinkedList<Integer> entry = new LinkedList();
        LinkedList<Integer> exit = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (direction[i] == 0) {
                entry.add(i);
            } else {
                exit.add(i);
            }
        }
        int prev = -1;
        int currTime = 0;

        while (!entry.isEmpty() && !exit.isEmpty()) {
            int currEntry = entry.peek();
            int currExit = exit.peek();
            int timeEntry = Math.max(time[currEntry], currTime);
            int timeExit = Math.max(time[currExit], currTime);

            if (timeEntry < timeExit) {
                entry.remove();
                res[currEntry] = timeEntry;
                prev = setPrevious(true, currTime, timeEntry, prev);
                currTime = timeEntry;
            } else if (timeEntry > timeExit) {
                exit.remove();
                currTime = timeExit;
                res[currExit] = timeExit;
                prev = setPrevious(false, currTime, timeExit, prev);
                currTime = timeExit;
            } else {
                if (prev == -1 || prev == 1) {
                    exit.remove();
                    res[currExit] = timeExit;
                    prev = setPrevious(false, currTime, timeExit, prev);
                    currTime = timeExit;
                } else {
                    entry.remove();
                    res[currEntry] = timeEntry;
                    prev = setPrevious(true, currTime, timeEntry, prev);
                    currTime = timeEntry;
                }
            }
            currTime = currTime + 1;
        }

        while (!entry.isEmpty()) {
            int currEntry = entry.remove();
            currTime = Math.max(currTime, time[currEntry]);
            res[currEntry] = currTime;
            currTime += 1;
        }

        while (!exit.isEmpty()) {
            int currExit = exit.remove();
            currTime = Math.max(currTime, time[currExit]);
            res[currExit] = currTime;
            currTime += 1;
        }

        return res;
    }

    public static int setPrevious(boolean entry, int currTime, int time, int prev) {
        if (time > currTime) {
            prev = -1;
        } else {
            prev = entry ? 0 : 1;
        }
        return prev;
    }
}
