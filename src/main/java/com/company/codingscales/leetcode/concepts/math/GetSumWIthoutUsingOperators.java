package com.company.codingscales.leetcode.concepts.math;

public class GetSumWIthoutUsingOperators {
    public int getSum(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;

            System.out.println(Integer.toBinaryString(a));
            System.out.println(Integer.toBinaryString(b));
            System.out.println(Integer.toBinaryString(answer));
            System.out.println(Integer.toBinaryString(a & b));
            System.out.println(Integer.toBinaryString((a & b) << 1));
            System.out.println("\n\n");
            a = answer;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) {
        GetSumWIthoutUsingOperators sol = new GetSumWIthoutUsingOperators();
        sol.getSum(15, 20);
    }
}
