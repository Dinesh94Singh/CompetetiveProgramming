package com.company.codingscales.interviews.microsoft;

public class Debug5 {
    static int solution(final int X, final int Y, final int[] A) {
        final int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for(int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;

            if (nX == nY)
                result = i;
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(solution(100, 63, new int[] { 100, 63, 1, 6, 2, 13 })); // should return 5
        System.out.println(solution(6, 13, new int[] { 13, 13, 1, 6 })); // should return -1
        System.out.println(solution(13, 13, new int[] { 13, 13, 1, 6 })); // should return -1
    }
}
