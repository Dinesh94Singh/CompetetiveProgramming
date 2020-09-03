package com.company.codingscales.interviews.microsoft;

public class LengthOfAnLinkedListRepresentedAsArray {
    public int findLength(final int[] input) {
        if (input == null || input.length == 0 || input[0] == -1)
            return 0;

        int length = 0;
        int index = 0;
        while (true) {
            index = input[index];
            length++;
            if (index == -1)
                break;
        }
        return length;
    }
}
