package com.company.codingscales.interviews.microsoft;

public class Debug3 {
    // cross check with the asked question
    static int solution(final int[] A) {
        final int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;

        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i; // modified to i ? should this be the answer ?
                }
            } else {
                k = 0;
            }
            i = i - 1;
        }
        if (A[i] == 1 && k + 1 > maximal) { // i = 0 and
            result = 0;
        }
        return result;
    }

    public static void main(final String[] args) {
        System.out.println(solution(new int[] { 0, 0 })); // -1
        System.out.println(solution(new int[] { 0, 0, 1 })); // 2
        System.out.println(solution(new int[] { 0, 1, 1, 0, 1, 1, 1 })); // max seq starts at 4? res is 4?
        System.out.println(solution(new int[] { 1, 1, 1, 1, 0, 0, 1, 1, 1 })); // max seq starts at 0? res is 0?
    }
}
