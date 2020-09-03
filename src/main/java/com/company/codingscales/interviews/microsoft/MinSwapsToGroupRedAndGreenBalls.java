package com.company.codingscales.interviews.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MinSwapsToGroupRedAndGreenBalls {
    public static int solution(final String s) {
        final List<Integer> redIndices = getRedIndices(s);
        final int mid = redIndices.size() / 2;
        long minSwaps = 0;
        for (int i = 0; i < redIndices.size(); i++) {
            // number of swaps for each R is the distance to mid, minus the number of R's between them
            minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
        }
        return minSwaps > 100000 ? -1 : (int) minSwaps;
    }

    private static List<Integer> getRedIndices(final String s) {
        final List<Integer> indices = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(final String[] args) {
        System.out.println(solution("RWRW"));
    }
}
