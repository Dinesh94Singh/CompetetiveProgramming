package com.company.codingscales.binarysearchio.concepts.arrays;

// Dutch national Flag problem
public class ListPartioning {
    private void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public String[] solve(String[] strs) {
        int i = 0, j = strs.length - 1;
        int k = 0;
        while (k <= j) {
            String s = strs[k];

            if (s.equals("red")) {
                swap(strs, i, k);
                i++;
                k++;
            } else if (s.equals("blue")) {
                swap(strs, j, k);
                j--;
            } else {
                k++;
            }
        }

        return strs;
    }
}
