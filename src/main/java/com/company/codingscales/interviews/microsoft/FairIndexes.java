package com.company.codingscales.interviews.microsoft;

public class FairIndexes {
    private static int getNumOfFairIndexes(final int[] A, final int[] B) {
        int res = 0, sumA = 0, sumB = 0;
        for(int i=0;i<A.length;i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int tmpA = 0, tmpB = 0;
        for(int i=0;i<A.length-1;i++) {
            tmpA += A[i];
            tmpB += B[i];
            if (sumA == 2 * tmpA && sumB == 2 * tmpB && tmpA == tmpB)
                res++;
        }
        return res;
    }

    public static void main(final String[] args) {
        final int[] A1 = {4,-1,0,3};
        final int[] B1 = {-2, 5, 0 ,3};
        final int[] A2 = {2,-2,-3,3};
        final int[] B2 = {0,0,4,-4};
        final int[] A3 = {4,-1,0,3};
        final int[] B3 = {-2,6,0,4};
        final int[] A4 = {3,2,6};
        final int[] B4 = {4,1,6};
        final int[] A5 = {1,4,2,-2,5};
        final int[] B5 = {7,-2,-2,2,5};
        System.out.println(getNumOfFairIndexes(A1, B1));
        System.out.println(getNumOfFairIndexes(A2, B2));
        System.out.println(getNumOfFairIndexes(A3, B3));
        System.out.println(getNumOfFairIndexes(A4, B4));
        System.out.println(getNumOfFairIndexes(A5, B5));
    }
}
