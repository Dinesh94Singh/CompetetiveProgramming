package com.company.codingscales.interviews.amazon;

import java.util.*;

public class ShoppingPatterns {

    public static int getMinScore(final int productNodes, final List<Integer> productsFrom, final List<Integer> productsTo) {
        final HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < productsFrom.size(); i++) {
            final int source = productsFrom.get(i);
            final int dest = productsTo.get(i);

            graph.putIfAbsent(source, new HashSet<>());
            graph.putIfAbsent(dest, new HashSet<>());

            graph.get(dest).add(source);
            graph.get(source).add(dest);
        }

        int minimum = Integer.MAX_VALUE;
        for(int x = 1; x <= productNodes; x++) {
            for(int i = 0; i < productsFrom.size(); i++) {
                final int y = productsFrom.get(i);
                final int z = productsTo.get(i); // y - z exists
                if (x != y && x != z && y != z) {
                    // check if xy & xz exists in the graph
                    if (graph.get(x).contains(y) && graph.get(x).contains(z)) {
                        // forms a triangle
                        int sum = 0;
                        sum += (graph.get(x).size() - 2); // y - z exist
                        sum += (graph.get(y).size() - 2);
                        sum += (graph.get(z).size() - 2);

                        minimum = Math.min(sum, minimum);
                    }
                }
            }
        }

        return minimum;
    }

    public static void main(String[] args) {
        final Integer[] from = {1, 2, 2, 3, 4, 5};
        final Integer[] to = {2, 4, 5, 5, 5, 6};

        List<Integer> productsFrom =  Arrays.asList(from);
        List<Integer> productsTo = Arrays.asList(to);
        System.out.println(getMinScore(6, productsFrom, productsTo));
    }
}
