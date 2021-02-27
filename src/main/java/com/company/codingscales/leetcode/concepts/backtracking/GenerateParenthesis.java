package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rec_helper(res,0,0,n,sb);
        return res;
    }

    private void rec_helper(List<String> res, int open, int close, int n,StringBuilder sb) {
        //when we have reached 2n, we add to ourresult
        if(2*n == sb.length()) {
            res.add(sb.toString());
            return;
        }


        //we can put open brackets till open < n
        if(open<n) {
            sb.append("(");
            rec_helper(res,open+1, close, n,sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        //when can we put close?????
        if(open > close) {
            sb.append(")");
            rec_helper(res,open,close+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
