package com.company.codingscales.leetcode.concepts.strings;

public class WordsTyping {
    /**
     * further optimizations, store the index of sentence array & x position at the beginning of sentence =>
     *  * You can count + rows takes for each complete sentence.
     *  * If there are these many rows left, then we can store in dp and add that directly.
     */
    public static int wordsTyping(final String[] sentence, final int rows, final int cols) {
        int x = 0, y = 0;
        int index = 0, count = 0;

        while(true) {
            System.out.printf("%d %d \n", x, y);
            final int remaining = cols - x;
            if (remaining >= sentence[index].length()) {
                x += sentence[index++].length();
                if (x != cols)
                    x += 1;
            } else {
                x += sentence[index].length(); // sentence is not going to fit
            }

            if (index == sentence.length) {
                count++;
                index = 0;
            }

            if (x >= cols) {
                y++;
                x = 0;
                if (y == rows) {
                    break;
                }
            }
        }

        System.out.println("\n results !! ");
        return count;
    }

    public static int wordsTypingOptimized(final String[] sentence, final int rows, final int cols) {
        int y = 0, x = 0, index = 0;
        int count = 0;
        int total = 0;

        for(final String each : sentence) {
            total += each.length();
        }

        total += sentence.length; // for the white space

        while (y < rows) {
            final int len = sentence[index].length();
            final int remaining = cols - x;
            if (remaining == len) {
                index++;
                y++;
                x = 0;
            } else if (remaining > len) {
                if (remaining > total) {
                    count += (remaining) / total; // you can add these many sentences
                    x += (remaining) / total * total;
                } else {
                    x += len + 1; // 1 for the space
                    index++;
                }
            } else {
                y++;
                x = 0;
            }

            if (index == sentence.length) {
                count++;
                index = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] input = {"I", "had", "apple", "pie"};
        System.out.println(wordsTyping(input, 4, 5)); // should return 3;
        input = new String[]{"a", "bcd", "e"};
        System.out.println(wordsTyping(input, 3, 6)); // should return 3;
    }
}
