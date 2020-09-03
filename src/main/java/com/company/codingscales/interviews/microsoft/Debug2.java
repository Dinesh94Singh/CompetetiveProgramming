package com.company.codingscales.interviews.microsoft;

public class Debug2 {
    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0)
                enable_print = 1;
            if (enable_print == 1) { // changed for else if to if
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    public static void main(final String[] args) {
        solution(54321);
        System.out.println();
        solution(10011);
        System.out.println();
        solution(1);
        System.out.println();
        solution(100); // should only print 1
        System.out.println();
        solution(1);
    }
}
