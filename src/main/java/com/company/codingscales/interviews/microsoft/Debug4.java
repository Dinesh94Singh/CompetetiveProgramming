package com.company.codingscales.interviews.microsoft;

public class Debug4 {
    public static boolean solution(final int[] A, final int K) {
        // A is sorted in increasing order
        final int n = A.length;
        for(int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        // changed && to ||
        return A[0] == 1 && A[n - 1] == K;
    }

    public static void main(final String[] args) {
        System.out.println(solution(new int[] { 1, 2, 2, 3}, 3));
        System.out.println(solution(new int[] { 1, 2, 3, 4}, 3));
        System.out.println(solution(new int[] { 1, 2, 2, 4}, 3));
    }
}
