package com.company.codingscales.leetcode.concepts.strings;

import javafx.util.Pair;

public class CompareVersions {
    public int compareVersion(String A, String B) {
        int M = A.length();
        int N = B.length();

        int i = 0, j = 0;

        Pair<Integer, Integer> p1;
        Pair<Integer, Integer> p2;
        while (i < M || j < N) {
            p1 = getNextChunk(A, M, i);
            i = p1.getValue(); // for next pass
            p2 = getNextChunk(B, N, j);
            j = p2.getValue(); // for next pass

            if (p1.getKey() != p2.getKey())
                return p1.getKey() > p2.getKey() ? 1 : -1;
        }

        return 0;
    }

    /**
     * @param s        - string for the chunk
     * @param n        - length of the string
     * @param startIdx - the index from which, we are trying to find the next '.'
     */
    Pair<Integer, Integer> getNextChunk(String s, int n, int startIdx) {
        if (startIdx >= n) {
            return new Pair<>(0, startIdx);
        }

        int i = startIdx;
        while (i < n && s.charAt(i) != '.') {
            i++;
        }
        int key;

        if (i != n - 1) {
            key = Integer.parseInt(s.substring(startIdx, i));
        } else {
            key = Integer.parseInt(s.substring(startIdx)); // ended due to i < n condition
        }

        i++; //
        return new Pair<>(key, i);
    }
}
