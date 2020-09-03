package com.company.codingscales.leetcode.concepts.strings;

public class SolveTheEquation {
    private static int[] parse(String side) {
        char[] arr = side.toCharArray();
        int sign = 1;

        int coef = 0, constant = 0;
        int i = 0;

        while (i < arr.length) {
            char ch = arr[i];

            if (ch == '+') { sign = 1; i++; }
            else if (ch == '-') { sign = -1; i++; }
            else {
                int j = i;
                while (j < arr.length && Character.isDigit(arr[j])) {
                    j++;
                }

                String substring = side.substring(i, j);
                int num = 1;

                if (substring.isEmpty()) { num = 1; }
                else { num = Integer.parseInt(side.substring(i, j)); }

                if (j < arr.length && arr[j] == 'x') {
                    coef += (sign * num);
                    j++;
                } else { constant += (sign * num); }

                i = j;
            }
        }

        return new int[]{coef, constant};
    }

    public static String solveEquation(String equation) {
        String[] sides = equation.split("=");

        int[] left = parse(sides[0]);
        int[] right = parse(sides[1]);

        int leftConst, rightConst, leftCoef, rightCoef;

        leftCoef = left[0];
        leftConst = left[1];

        rightCoef = right[0];
        rightConst = right[1];

        if (leftCoef - rightCoef == 0) {
            if (rightConst - leftConst == 0) {
                return "Infinite Solutions";
            } else {
                return "No solution";
            }
        }

        int val = (rightConst - leftConst) / (leftCoef - rightCoef);

        return "x=" + val;
    }

    public static void main(String[] args) {
        SolveTheEquation sol = new SolveTheEquation();
        System.out.println(sol.solveEquation("x+5-3+x=6+x-2"));
    }

}
