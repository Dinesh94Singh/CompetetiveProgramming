package com.company.codingscales.leetcode.FacebookTagged;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveInvalidParenthesis {
    Set<String> res = new HashSet<>();
    int min_removed = Integer.MAX_VALUE;

    private void recHelper(String s, int idx, int open, int close, List<Character> t, int count) {
        if (s.length() == idx) {
            if (open == close) {
                if (min_removed > count) {
                    min_removed = count;
                    res.clear();
                    res.add(t.stream().map(String::valueOf).collect(Collectors.joining("")));
                    return;
                } else if (min_removed == count) {
                    res.add(t.stream().map(String::valueOf).collect(Collectors.joining("")));
                    return;
                }
            }
            return;
        }

        char ch = s.charAt(idx);
        if (!(ch == '(' || ch == ')')) {
            t.add(ch);
            recHelper(s, idx + 1, open, close, t, count);
            t.remove(t.size() - 1);
            return;
        }

        recHelper(s, idx + 1, open, close, t, count + 1); // skip and see
        if (ch == '(') {
            t.add(ch);
            recHelper(s, idx + 1, open + 1, close, t, count);
            t.remove((t.size() - 1));
        } else if (ch == ')' && open > close) {
            t.add(ch);
            recHelper(s, idx + 1, open, close + 1, t, count);
            t.remove((t.size() - 1));
        }

    }

    public List<String> removeInvalidParenthesis(String s) {
        recHelper(s, 0, 0, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    // --------------------------------------------------------------------------------------------

    public List<String> removeInvalidParenthesisWithoutExtraSpaceAndHashSet(String s) {
        /**
         * Idea
         *
         * Without hashset, end up in duplicates
         *  1. To remove hashset, we have to make sure, if there are similar parens ")" at multiple indices, only delete the first one.
         *  2. If prefix is then valid (open and closed are matched, we process further). We also need lastRemovalIdx
         */
        List<String> res = new ArrayList<>();
        dfs2(s, res, 0, 0, '(', ')');
        return res;
    }

    // refer to ipad notes with examples => you got this (goodnotes)
    public void dfs2(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        dfs2(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            dfs2(reversed, output, 0, 0, ')', '(');
        else
            output.add(reversed);
    }

    public List<String> removeInvalidParenthesisUsingBFS(String s) {
        return new ArrayList<>();
    }


    /**
     * Example 1:
     * <p>
     * Input: s = "()())()"
     * Output: ["(())()","()()()"]
     * Example 2:
     * <p>
     * Input: s = "(a)())()"
     * Output: ["(a())()","(a)()()"]
     * Example 3:
     * <p>
     * Input: s = ")("
     * Output: [""]
     */
    public static void main(String[] args) {

    }
}
