package com.company.codingscales.interviews.amazon;

public class LabellingSystem {
    // Function to find the largest lexicographical String with given constraints.
    static String getLargestString(String s, int k) {
        int[] frequency_array = new int[26];

        // Assigning frequency
        for (int i = 0; i < s.length(); i++) {
            frequency_array[s.charAt(i) - 'a']++;
        }

        // Empty String of String class type
        StringBuilder ans = new StringBuilder();

        // Loop to iterate over maximum priority first.
        for (int i = 25; i >= 0; ) {
            // If frequency is greater than or equal to k.
            if (frequency_array[i] > k) {
                // Temporary variable to operate in-place of k.
                int temp = k;
                while (temp > 0) {
                    // Concatenating with the resultant String ans.
                    ans.append((char) i + 'a');
                    temp--;
                }

                frequency_array[i] -= k;

                // Handling k case by adjusting with just smaller priority element.
                int j = i - 1;

                while (frequency_array[j] <= 0 && j >= 0) {
                    j--;
                }

                // Condition to verify if index j does have frequency greater than 0;
                if (frequency_array[j] > 0 && j >= 0) {
                    ans.append((char)(j + 'a'));
                    frequency_array[j] -= 1;
                } else {
                    // If no such element is found than String can not be processed further.
                    break;
                }
            } else if (frequency_array[i] > 0) {
                // If frequency is greater than 0 and less than k. Here we don't need to fix K consecutive element criteria.
                int temp = frequency_array[i];
                frequency_array[i] -= temp;
                String st = String.valueOf((char)(i + 'a'));

                while (temp > 0) {
                    ans.append((char)(i + 'a'));
                    temp--;
                }
            } else {
                // Otherwise check for next possible element.
                i--;
            }
        }
        return ans.toString();
    }
}
