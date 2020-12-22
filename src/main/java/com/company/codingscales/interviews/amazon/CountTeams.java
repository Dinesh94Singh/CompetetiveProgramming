package com.company.codingscales.interviews.amazon;

import java.util.Arrays;

public class CountTeams {
    // Function to compute the value of Binomial Coefficient C(n, k)
    static int binomialCoeff(int n, int k) {
        int[][] C = new int[n + 1][k + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][k];
    }

    static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo +  (hi - lo) / 2);
            if  (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    /**
     * Sort the skill level of players.
     * Now we can easily find the lower bound and upper bound for the total number of players that can be used in a team.
     * The list includes associates with skill levels [12, 4, 6, 13,5, 10].
     * They want to hire at least 3 associates with skill levels between 4 and 10, inclusive.
     * Four of the associates with the following skill levels {4, 6,5,10} meet the criteria.
     * There are 5 ways to form a team of 3 associates : {4,5,6}, {4, 6, 10}, {4,5,10}, {5, 6, 10}, and {4, 5, 6, 10}.
     * So the output is 5.
     */
    static int countTeams(int[] arr, int lb, int ub, int k) {
        Arrays.sort(arr);

        int lb_index = binarySearch(arr, lb);
        int ub_index = binarySearch(arr, ub + 1);

        int N = ub_index - lb_index;

        if (N < k)
            return 0;

        int total = 0;

        for(int i = k; i <= N; i++)
            total += binomialCoeff(N, i);

        return total;
    }


    public static void main(String[] args) {
        System.out.println(countTeams(new int[]{12, 4, 6, 13, 5, 10}, 4, 10, 3));
    }
}
