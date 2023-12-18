package com.company.codingscales.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testcases = scan.nextInt();
        for (int i = 0; i < testcases; i++) {
            String s = scan.next();
            String[] parts = s.split("\\s+");

            int n = Integer.parseInt(parts[0]);
            int len = Integer.parseInt(parts[1]);

            System.out.println(solve(n, len));
        }

        scan.close();
    }

    private static int solve(int n, int len) {
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            al.add(n ^ i);
        }

        return 0;
    }

}
