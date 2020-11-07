package com.company.codingscales.interviews.amazon;

import java.util.Arrays;

public class CutOffRank {
    static int solve(int cutOffRank, int size, int[] s) {
        Integer[] scores = (Integer[]) Arrays.stream(s).boxed().toArray();
        Arrays.sort(scores, (e1, e2) -> (int) e2 - (int) e1);

        int i = 0;
        int rank = 0;

        while (rank <= cutOffRank && i < size) {
            if (i == 0 || !scores[i].equals(scores[i - 1]))
                rank = i + 1;

            if (rank > cutOffRank)
                break;
            i++;
        }

        return i;
    }
}
