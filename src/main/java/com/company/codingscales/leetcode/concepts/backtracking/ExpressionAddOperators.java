package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.isEmpty()) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') // don't allow 05, 056 etc., Only 0 can be allowed
                break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    static class SolutionRedo {
        char[] A;
        List<String> res = new ArrayList<>();
        public List<String> addOperators(String num, int target) {
            A = num.toCharArray();

            dfs(0, target, new ArrayList<>(), 0, 0);
            return res;
        }

        char[] operations = {'+', '-', '*'};

        private void dfs(int idx, int target, List<String> al, long val, long prev) {
            if (idx == A.length) {
                if (target == val)
                    res.add(al.stream().collect(Collectors.joining("")));
                return;
            }

            long n = 0;
            for(int i = idx; i < A.length; i++) {
                n = n * 10 + Character.getNumericValue(A[i]);

                if (i != idx && A[idx] == '0') // don't allow leading zeros.
                    break;

                if (idx == 0) {
                    al.add("" + n);
                    dfs(i + 1, target, al, n, n);
                    al.remove(al.size() - 1);
                } else {
                    for(char ch : operations) {
                        al.add("" + ch);
                        al.add("" + n);

                        if (ch == '+') {
                            dfs(i + 1, target ,al, val + n, n);
                        } else if (ch == '-') {
                            dfs(i + 1, target, al, val - n, -n);
                        } else if (ch == '*') { // same works for division as well.
                            dfs(i + 1, target, al, (val - prev) + (prev * n), prev * n);
                        }

                        al.remove(al.size() - 1);
                        al.remove(al.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators eao = new ExpressionAddOperators();
        eao.addOperators("105", 5);
    }
}
