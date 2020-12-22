package com.company.codingscales.interviews.amazon;

import java.util.*;

public class NearestCities { // passes all test cases
    public static String[] findNearestCities(int numOfCities, String[] cities, int[] xCoordinates, int[] yCoordinates, int numOfQueries, String[] queries) {
        HashMap<String, int[]> graph = new HashMap<>();
        HashMap<Integer, List<String>> xMap = new HashMap<>();
        HashMap<Integer, List<String>> yMap = new HashMap<>();

        for(int i = 0; i < numOfCities; i++) {
            graph.put(cities[i], new int[]{xCoordinates[i], yCoordinates[i]});

            xMap.putIfAbsent(xCoordinates[i], new ArrayList<>());
            xMap.get(xCoordinates[i]).add(cities[i]);

            yMap.putIfAbsent(yCoordinates[i], new ArrayList<>());
            yMap.get(yCoordinates[i]).add(cities[i]);
        }


        String[] res = new String[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int[] point = graph.get(query);

            Set<String> neighbors = new HashSet<>(xMap.get(point[0]));
            neighbors.addAll(yMap.get(point[1]));

            double nearest = Integer.MAX_VALUE;
            String key = null;
            for(String each : neighbors) {
                if (each != query) {
                    int[] otherPoint = graph.get(each);
                    double t = Math.pow((otherPoint[1] - point[1]), 2) + Math.pow((otherPoint[0] - point[0]), 2);
                    if (t < nearest) {
                        key = each;
                        nearest = t;
                    } else if (t == nearest && each.compareTo(key) < 0) {
                        key = each;
                    }
                }
            }

            if (nearest == Integer.MAX_VALUE)
                res[i] = "None";
            else
                res[i] = key;
        }

        return res;
    }

    /**
     *                                                      (30, 40, blue)
     *
     * (10,30, green) (15, 30, red)
     * (10, 25, grey) (15, 25, pink)         (20, 25, yellow)
     *
     */
    public static void main(String[] args) {
//        numOfCities=6, cities=[green,yellow,red,blue,grey,pink], xCoordinates=[10,20,15,30,10,15], yCoordinates=[30,25,30,40,25,25], numOfQueries=4, queries=[grey,blue,red,pink] Expected: [green,null,green,grey] Output: [pink,null,pink,red]

        String[] res = findNearestCities(6, new String[]{"green", "yellow", "red", "blue", "grey", "pink"}, new int[]{10, 20, 15, 30, 10, 15}, new int[]{30, 25, 30, 40, 25, 25}, 4, new String[]{"grey", "blue", "red", "pink"});

        System.out.println("Done !!");
    }
}
