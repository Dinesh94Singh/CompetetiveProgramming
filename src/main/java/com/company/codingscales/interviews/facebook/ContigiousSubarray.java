package com.company.codingscales.interviews.facebook;

import java.util.Stack;

public class ContigiousSubarray {
    /**
     You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
     The value at index i must be the maximum element in the contiguous subarrays, and
     These contiguous subarrays must either start from or end on index i.
     Signature
     int[] countSubarrays(int[] arr)
     Input
     Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
     Size N is between 1 and 1,000,000
     Output
     An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
     Example:
     arr = [3, 4, 1, 6, 2]
     output = [1, 3, 1, 5, 1]
     Explanation:
     For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
     For index 1 - [4], [3, 4], [4, 1]
     For index 2 - [1]
     For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
     For index 4 - [2]
     So, the answer for the above input is [1, 3, 1, 5, 1]
    **/
    int[] countSubarrays(int[] arr) {
        // number of sub-arrays formed at index - i
        // Either Start At Index i (or) end At index i
        // i should be the maximum val in the sub array
        // At each index, find how many such sub-arrays exist

        // if we find the maxLength either left or right -> (n * (n + 1) / 2) would be the length
        Stack<Integer> st = new Stack<>();
        int[] L = new int[arr.length];
        L[0] = 1; // Sub array of length 1

        st.push(0); // indices
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                L[i] = i + 1; // till 0th index, hence i + 1
            } else {
                L[i] = i - st.peek(); // max sub array length
            }

            st.push(i);
        }

        int[] R = new int[arr.length];
        R[R.length - 1] = 1;

        st.clear();
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                R[i] = (arr.length - i) + L[i] - 1;
            } else {
                R[i] = (st.peek() - i) + L[i] - 1;
            }

            st.push(i);
        }

        return R;
    }
}
