package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {
    HashSet<String> al;
    int minRemoved = Integer.MAX_VALUE;

    void dfs(int idx, String s, int open, int close, int remaining, List<Character> l) {
        if (idx == s.length()) {
            if (open == close) {
                if (minRemoved > remaining) {
                    al.clear();
                    minRemoved = remaining;
                    al.add(l.stream().map(String::valueOf).collect(Collectors.joining("")));
                } else if (minRemoved == remaining) {
                    al.add(l.stream().map(String::valueOf).collect(Collectors.joining("")));
                }
            }
            return;
        }

        char ch = s.charAt(idx);

        if (Character.isAlphabetic(ch)) {
            l.add(ch);
            dfs(idx + 1, s, open, close, remaining, l);
            l.remove(l.size() - 1);
        } else {
            dfs(idx + 1, s, open, close, remaining + 1, l);

            if (ch == '(') {
                l.add(ch);
                dfs(idx + 1, s, open + 1, close, remaining, l);
                l.remove(l.size() - 1);
            } else if (open > close) {
                l.add(ch);
                dfs(idx + 1, s, open, close + 1, remaining, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public List<String> removeInvalidParenthesesUsingHashSet(String s) {
        al = new HashSet<>();
        dfs(0, s, 0, 0, 0, new ArrayList<>());
        return new ArrayList<>(al);
    }


    // Use this solution.
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')', '(');
        else
            output.add(reversed);
    }

    /** Refereed to this solution
     *
     * class DFSSolution:
     *     def remove_invalid_parentheses(self, s):
     *         if not s:
     *             return [s]
     *
     *         results = []
     *         self.remove(s, 0, 0, results)
     *         return results
     *
     *     def remove(self,
     *                str_to_check,
     *                start_to_count,
     *                start_to_remove,
     *                results,
     *                pair=['(', ')']):
     *         # start_to_count: the start position where we do the +1, -1 count,
     *         # which is to find the position where the count is less than 0
     *         #
     *         # start_to_remove: the start position where we look for a parenthesis
     *         # that can be removed
     *
     *         count = 0
     *         for count_i in range(start_to_count, len(str_to_check)):
     *             if str_to_check[count_i] == pair[0]:
     *                 count += 1
     *             elif str_to_check[count_i] == pair[1]:
     *                 count -= 1
     *
     *             if count >= 0:
     *                 continue
     *
     *             # If it gets here, it means count < 0. Obviously.
     *             # That means from start_to_count to count_i (inclusive), there is an extra
     *             # pair[1].
     *             # e.g. if sub_str = ()), then we can remove the middle )
     *             # e.g. if sub_str = ()()), the we could remove sub_str[1], it becomes (())
     *             #  or we could remove sub_str[3], it becomes ()()
     *             # In the second example, for the last two )), we want to make sure we only
     *             # consider remove the first ), not the second ). In this way, we can avoid
     *             # duplicates in the results.
     *             #
     *             # In order to achieve this, we need this condition
     *             #  str_to_check[remove_i] == pair[1] and str_to_check[remove_i - 1] != str_to_check[remove_i]
     *             # But what if str_to_check[start_to_remove] == pair[1],
     *             # then remove_i - 1 is out of the range(start_to_remove, count_i + 1)
     *             # so we need
     *             # str_to_check[remove_i] == pair[1] and (start_to_remove == remove_i or str_to_check[remove_i - 1] != str_to_check[remove_i])
     *             for remove_i in range(start_to_remove, count_i + 1):
     *                 if str_to_check[remove_i] == pair[1] and (start_to_remove == remove_i or str_to_check[remove_i - 1] != str_to_check[remove_i]):
     *                     # we remove str_to_check[remove_i]
     *                     new_str_to_check = str_to_check[0:remove_i] + str_to_check[remove_i + 1:]
     *
     *                     # The following part are the most confusing or magic part in this algorithm!!!
     *                     # I'm too stupid and it took me two days to figure WTF is this?
     *                     #
     *                     # So for start_to_count value
     *                     # we know in str_to_check, we have scanned up to count_i, right?
     *                     # The next char in the str_to_check we want to look at is of index (count_i + 1) in str_to_check
     *                     # We have remove one char bewteen start_to_remove and count_i inclusive to get the new_str_to_check
     *                     # So the char we wanted to look at is of index (count_i + 1 - 1) in the new_str_to_check. (-1 because we removed one char)
     *                     # That's count_i. BOOM!!!
     *                     #
     *                     # Same reason for remove_i
     *                     # In str_to_check, we decide to remove the char of index remove_i
     *                     # So the next char we will look at to decide weather we want to remove is of index (remove_i + 1) in str_to_check
     *                     # we have remove [remove_i] char of the str_to_check to get the new_str_to_check.
     *                     # So the char we wanted to look at when doing remove is of index (remove_i + 1 - 1) in the new_str_to_check.
     *                     # That's remove_i. BOOM AGAIN!!!
     *                     new_start_to_count = count_i
     *                     new_start_to_remove = remove_i
     *                     self.remove(new_str_to_check,
     *                                 new_start_to_count,
     *                                 new_start_to_remove,
     *                                 results,
     *                                 pair)
     *
     *             # Don't underestimate this return. It's very important
     *             # if inside the outer loop, it reaches the above inner loop. You have scanned the str_to_check up to count_i
     *             # In the above inner loop, when construct the new_str_to_check, we include the rest chars after count_i
     *             # and call remove with it.
     *             # So after the above inner loop finishes, we shouldn't allow the outer loop continue to next round because self.remove in the
     *             # inner loop has taken care of the rest chars after count_i
     *             return
     *
     *         # Why the hell do we need to check the reversed str?
     *         # Because in the above count calculation, we only consider count < 0 case to remove stuff.
     *         # The default pair is ['(', ')']. So we only consider the case where there are more ')'  than '('
     *         # e.g "(()" can pass the above loop
     *         # So we need to reverse it to ")((" and call it with pair [')', '(']
     *         reversed_str_to_check = str_to_check[::-1]
     *         if pair[0] == '(':
     *             self.remove(reversed_str_to_check, 0, 0, results, pair=[')', '('])
     *         else:
     *             results.append(reversed_str_to_check)
     */
}
