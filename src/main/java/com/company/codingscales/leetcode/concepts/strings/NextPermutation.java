package com.company.codingscales.leetcode.concepts.strings;

public class NextPermutation {
    /*
        * Find the index, which sees a decrease
        * Find the number, just larger than the element at Index from end
        * Swap these 2 numbers and sort from index + 1 till end.
        * If not sort, you can reverse it as well, since they are already sorted.
     */
    public void nextPermutation(int arr[]) {
        if (arr.length == 0 || arr.length == 1) { return; }
        int i, j;
        for(i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i+1, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
