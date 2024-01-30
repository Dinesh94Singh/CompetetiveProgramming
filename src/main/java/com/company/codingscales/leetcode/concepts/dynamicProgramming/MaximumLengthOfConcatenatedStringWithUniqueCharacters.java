package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.*;
import java.util.stream.*;

/**
 * MaximumLengthOfConcatenatedStringWithUniqueCharacters
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    class MaximumLengthOfConcatenatedStringWithUniqueCharactersRecursiveSolution {
        int maximum = 0;

        public int maxLength(List<String> arr) {
            HashSet<Character> chars = new HashSet<>();

            List<String> A = new ArrayList<>();
            for (String word : arr) {
                Set<Character> s = word.chars().mapToObj(x -> (char) x).collect(Collectors.toSet());

                if (word.length() == s.size()) {
                    A.add(word);
                }
            }

            dfs(A, 0, chars);
            return maximum;
        }

        private void dfs(List<String> arr, int idx, HashSet<Character> chars) {
            if (idx == arr.size()) {
                maximum = Math.max(chars.size(), maximum);
                return;
            }

            dfs(arr, idx + 1, chars);
            String word = arr.get(idx);

            boolean found = false;

            for (char ch : word.toCharArray()) {
                if (chars.contains(ch)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                List<Character> all = word.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

                chars.addAll(all);
                dfs(arr, idx + 1, chars);
                chars.removeAll(all);
            }

        }
    }
}
