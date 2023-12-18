package com.company.codingscales.contests;

import javafx.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class Q5 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y) -> {
            return y.getValue() - x.getValue();
        });

        if (a > 0)
            pq.offer(new Pair<>('a', a));

        if (b > 0)
            pq.offer(new Pair<>('b', b));

        if (c > 0)
            pq.offer(new Pair<>('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair<Character, Integer> t1 = pq.poll();

            int minOccr = Math.min(2, t1.getValue());

            for (int k = 0; k < minOccr; k++) {
                sb.append(t1.getKey());
            }

            if (pq.isEmpty()) {
                return sb.toString();
            }

            Pair<Character, Integer> t2 = pq.poll();
            int minOccr2 = Math.min(2, t2.getValue());

            for (int k = 0; k < minOccr2; k++) {
                sb.append(t2.getKey());
            }

            if (t1.getValue() - minOccr > 0) {
                pq.offer(new Pair<>(t1.getKey(), t1.getValue() - minOccr));
            }

            if (t2.getValue() - minOccr2 > 0) {
                pq.offer(new Pair<>(t2.getKey(), t2.getValue() - minOccr2));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws ParseException {
        String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]";
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

        // sdf.parse("20230831");
        // Date t = sdf.parse("8/31/2023");
        Date t2 = sdf.parse("2023-08-31");

        System.out.println(t2.toString());
    }
}
