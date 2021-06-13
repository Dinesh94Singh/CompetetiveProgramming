package com.company.codingscales.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] nextArray() {
        int n = nextInt(); // read the input size
        int[] a = new int[n];
        Arrays.copyOfRange(a, 2, n);

        for(int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    ArrayList<Integer> nextArrayList() {
        int n = nextInt(); // read the input size
        ArrayList<Integer> al = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            al.add(nextInt());
        return al;
    }


    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
