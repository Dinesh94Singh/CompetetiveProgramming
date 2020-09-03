package com.company.codingscales.interviews.microsoft;

public class MinMovesToObtainStringWithout3ConsecutiveLetters {
    private static int solve(final String input) {
        final char[] s = input.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length;) {
            int next = i + 1;
            while (next < s.length && s[i] == s[next]) {
                next++;
            }
            int distance = next - i;

            if (distance >= 3) {
                // possible invalid patterns => baaab, baaaab, baaaaab. If you have more than 5, it can be reduces to one of the three possibilities
                // another set of invalid patterns => abbba, abbbba, abbbbba. Eg: abbbbbba -> can be reduced to -> bbabbba (dist 3) -> bbabbabb (total of 2 swaps)
                while (distance > 5) {
                    res += 1;
                    distance -= 3; // with each swap, we would remove 3 consequitive occurences
                }
                res += 1; // this uses 1 swap
            }
            i = next;
        }
        return res;
    }

    /**
     * T.C => O(n^2) => not O(n^3) even though there seems to be a nested loop, after the inner loop, we continue from where inner loop ended,
     * Further optimization can include, creating an LPS array and
     */
    public static void main(final String[] args) {
        System.out.println(solve("baaabbaabbba"));
    }
}
