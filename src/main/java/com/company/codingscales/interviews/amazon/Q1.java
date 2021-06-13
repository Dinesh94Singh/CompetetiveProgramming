package com.company.codingscales.interviews.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {
    static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        long inv_count = 0;
        int i = left;
        int j = mid;
        int k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }

    static long mergeSort(int arr[], int temp[], int left, int right) {
        int mid;
        long inv_count = 0;
        if (right > left) {
            mid = left + (right - left) / 2;
            inv_count = mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp,
                    mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }

        return inv_count;
    }

    static long solve(List<Integer> arr) {
        int[] A = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            A[i] = arr.get(i);
        int T[] = new int[arr.size()];
        return mergeSort(A, T, 0, arr.size() - 1);
    }

    public static long optimization(int n , int m, List<Integer> h, List<Integer> v) {
        return find(h) * find(v); // area of rectangle (l * b)
    }

    private static long find(List<Integer> arr) {
        Collections.sort(arr);
        int prev = -1;
        long max = Long.MIN_VALUE;
        long t = 0;
        for(int each :arr) { // for all the position where lines are missing
            if (each != prev + 1) {
                t = 0; // count. If continuously blocks are missing like 2,3,4 => t becomes 3. indicating 3 blocks
            }
            prev = each;
            t++;
            max = Math.max(max, t);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        List<Integer> t = new ArrayList<Integer>();
        t.add(7);
        t.add(1);
        t.add(2);
        System.out.println(solve(t));
    }
}
