package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.*;

// initially we might think, bfs would work, but the path might not exist, and there is no guarantee to specify which path to take and which path leads to possible destination, so we do backtracking
public class ReconstructItinerary {
    int N;
    List<String> res;

    boolean recHelper(final List<String> path, final String source, final HashMap<String, List<Boolean>> visited, final HashMap<String, List<String>> graph) {
        if (path.size() == N) {
            res.addAll(path);

            return true;
        }

        final List<String> destinations = graph.getOrDefault(source, new ArrayList<>());
        for(int i = 0; i < destinations.size(); i++) {
            if (!visited.get(source).get(i)) {
                // if not visited
                final String dest = destinations.get(i);
                visited.get(source).set(i, true);
                path.add(dest);
                final boolean possible = recHelper(path, dest, visited, graph);
                path.remove(path.size() - 1);
                visited.get(source).set(i, false);

                if (possible)
                    return true;

            }
        }

        return false;
    }

    // you need
    public List<String> findItinerary(final List<List<String>> tickets) {
        N = tickets.size() + 1;
        final HashMap<String, List<String>> graph = new HashMap<>();
        final HashMap<String, List<Boolean>> visited = new HashMap<>();
        for(final List<String> itinerary : tickets) {
            graph.putIfAbsent(itinerary.get(0), new ArrayList<>());
            graph.get(itinerary.get(0)).add(itinerary.get(1));
        }

        for(final Map.Entry<String, List<String>> entry : graph.entrySet()) {
            entry.getValue().sort(String::compareTo);
            visited.put(entry.getKey(), new ArrayList<>());
            for (int i = 0; i < entry.getValue().size(); i++) {
                visited.get(entry.getKey()).add(false);
            }
        }

        res = new ArrayList<>();
        recHelper(new ArrayList<>(Arrays.asList("JFK")), "JFK", visited, graph);
        return res;
    }

    public static void main(String[] args) {
        final ReconstructItinerary itinerary = new ReconstructItinerary();
        final List<List<String>> path = new ArrayList<>();
        path.add(Arrays.asList("MUC", "LHR"));
        path.add(Arrays.asList("JFK","MUC"));
        path.add(Arrays.asList("SFO","SJC"));
        path.add(Arrays.asList("LHR","SFO"));

        itinerary.findItinerary(path);
    }
}
