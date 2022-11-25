package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] A) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < A.length) {
            int j = i;
            while (i < A.length - 1 && A[i + 1] == A[i] + 1) {
                i++;
            }

            if (i - j + 1 > 1)
                res.add("" + A[j] + "->" + A[i]);
            else
                res.add("" + A[i]);
            i++;
        }

        return res;
    }
}
