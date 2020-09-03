package com.company.codingscales.interviews.microsoft;

public class LargestMAlignedSubset {
    public static void main(final String[] args) {
        final int[] array = {-3, -2, 1, 0, 8, 7, 1};
        final int a = getLargestMAlignedSubset(array, 3);
        System.out.println(a);
    }

    private static int getLargestMAlignedSubset(final int[] array, final int M) {
        int result = 0;
        if (array == null || array.length == 0) return 0;

        final int length = array.length;

        // aggregate numbers by the reminder
        final int[] subsetSizeArray = new int[M];
        for (final int num : array) {
            // get reminders, and convert non-positive reminders to non-negative
            final int index = num < 0 ? (num % M + M) % M : num % M;
            result = Math.max(++subsetSizeArray[index], result);
        }
        return result < 2 ? 0 : result;
    }
}
