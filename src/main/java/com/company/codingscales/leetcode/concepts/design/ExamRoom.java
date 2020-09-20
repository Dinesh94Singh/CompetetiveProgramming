package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.Collections;

public class ExamRoom {
    ArrayList<Integer> list;
    int N;

    public ExamRoom(final int N) {
        list = new ArrayList<>();
        this.N = N;
    }

    public int seat() {
        int index = 0;
        int dist = 0;

        if (list.isEmpty()) {
            index = 0;
        } else {
            int best = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                int prev = list.get(i - 1);
                int curr = list.get(i);

                dist = (curr - prev) / 2;

                if (best < dist) {
                    best = dist;
                    index = prev + dist;
                }
            }

            if (best < (N - list.get(list.size() - 1) - 1)) {
                index = N - 1;
            }
        }


        list.add(index);
        Collections.sort(list);
        return index;
    }

    public void leave(final int p) {
        list.remove(new Integer(p));
    }

}
