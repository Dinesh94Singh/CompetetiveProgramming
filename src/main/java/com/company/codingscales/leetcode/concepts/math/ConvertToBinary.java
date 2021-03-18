package com.company.codingscales.leetcode.concepts.math;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBinary {
    private static String convertToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    private static int convertToInt(String s) {
        int res = 0;
        for(int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == 1) {
                res += (int) Math.pow(2, s.length() - j - 1);
            }
        }

        return res;
    }

    public static int solution(int N) {
        String s = convertToBinary(N);

        System.out.println(s);
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                indexes.add(i);

        if (indexes.isEmpty())
            return 0;

        if (indexes.size() == 1)
            return s.length() - indexes.get(0) - 1;

        int res = 0;
        for(int i = 1; i < indexes.size(); i++)
            res = Math.max(res, indexes.get(i) - indexes.get(i - 1) - 1);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(1041));
        System.out.println(solution(4));
    }
}
