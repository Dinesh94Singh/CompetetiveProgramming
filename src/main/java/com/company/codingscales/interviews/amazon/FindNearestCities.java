package com.company.codingscales.interviews.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// TODO: REDO
public class FindNearestCities {
    public static String[] findNearestCities(int numOfCities, String[] cities, int[] xCoordinates, int[] yCoordinates, int numOfQueries,
                                             String[] queries) {
        HashMap<String, Map.Entry<String, Integer>> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq[] = new PriorityQueue[numOfCities];
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            map1.put(cities[i], i);
        }
        for (int i = 0; i < pq.length; i++)
            pq[i] = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() != 0 ? a.getValue() - b.getValue() : a.getKey().compareTo(b.getKey()));
        for (int i = 0; i < xCoordinates.length; i++) {
            for (int j = 0; j < xCoordinates.length; j++) {
                if (i == j)
                    continue;
                if (xCoordinates[i] == xCoordinates[j]) {
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);
                    int d = x + y;
                    HashMap<String, Integer> m = new HashMap<>();
                    m.put(cities[j], d);
                    for (Map.Entry<String, Integer> e : m.entrySet())
                        pq[i].offer(e);
                }
            }
        }
        for (int i = 0; i < yCoordinates.length; i++) {
            for (int j = 0; j < yCoordinates.length; j++) {
                if (i == j)
                    continue;
                if (yCoordinates[i] == yCoordinates[j]) {
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);
                    int d = x + y;
                    HashMap<String, Integer> m = new HashMap<>();
                    m.put(cities[j], d);
                    for (Map.Entry<String, Integer> e : m.entrySet())
                        pq[i].offer(e);
                }
            }
        }
        String res[] = new String[numOfQueries];
        for (int i = 0; i < queries.length; i++) {
            int idx = map1.get(queries[i]);
            if (!pq[idx].isEmpty()) {
                Map.Entry<String, Integer> e = pq[idx].peek();
                res[i] = e.getKey();
            } else res[i] = null;
        }
        return res;
    }

    public static void main(String[] args) {
        int numOfCities = 6;
        String[] cities = {"green", "yellow", "red", "blue", "grey", "pink"};
        int[] xCoordinates = {10, 20, 15, 30, 10, 15};
        int[] yCoordinates = {30, 25, 30, 40, 25, 25};
        int numOfQueries = 4;
        String[] queries = {"grey", "blue", "red", "pink"};
        String res[] = findNearestCities(numOfCities, cities, xCoordinates, yCoordinates, numOfQueries, queries);
        for (String s : res)
            System.out.print(s + " ");
    }
}
