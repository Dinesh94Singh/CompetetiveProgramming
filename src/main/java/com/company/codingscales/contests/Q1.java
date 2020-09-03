package com.company.codingscales.contests;

import java.util.ArrayList;

public class Q1 {
    public static boolean containsPattern(int[] arr, int m, int limit) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int count = 0;
            int endPos = Math.min(i + m, n);
            ArrayList<Integer> al = new ArrayList<>();
            System.out.println(" Pattern is");
            for(int k = i; k < endPos; k++){
                System.out.print(arr[k] + " , ");
                al.add(arr[k]);
            }
            System.out.println();

            int j = i + m;
            while (j < n) {
                boolean ok = true;
                for(int k = 0; k < al.size() && j + k < n; k++){
                    if (arr[j + k] != al.get(k)) {
                        ok = false;
                        break;
                    }
                }
                if (!ok)
                    break;
                count++;
                j += m;
            }
            if (count >= limit - 1) {
                System.out.println(count + " - " + (limit - 1));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsPattern(new int[] {2, 2, 2, 2}, 2, 3)); // false
        System.out.println(containsPattern(new int[] {2,2,1,2,2,1,1,1,2,1}, 2, 2)); // false
    }
}
