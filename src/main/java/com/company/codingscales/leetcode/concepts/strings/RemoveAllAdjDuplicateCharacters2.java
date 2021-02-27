package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayDeque;

public class RemoveAllAdjDuplicateCharacters2 {
    public String removeDuplicates(final String S, final int k) {
        ArrayDeque<Integer> count = new ArrayDeque<>();
        char[] A = S.toCharArray();
        int i = 0, j = 0;

        while (i < A.length) {
            A[j] = A[i];
            if (j == 0 || A[j] != A[j - 1]) {
                count.offerLast(1);
            } else {
                int countSoFar = count.pollLast() + 1;
                if (countSoFar == k) {
                    j = j - k;
                } else {
                    count.offerLast(countSoFar);
                }
            }
            i++;
            j++;
        }

        return new String(A, 0, j);
    }
}
