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


    /**
     * O(ELogV) =>
     *
     */

    HashMap<String, LinkedList<String>> flightMap = new HashMap<>(); // graph
    LinkedList<String> result = null;

    // The basic idea of Hierholzer's algorithm is the stepwise construction of the Eulerian cycle by connecting disjunctive circles.
    // visited each node once and only once is called Hamiltonian.
    // Step 1). Starting from any vertex, we keep following the unused edges until we get stuck at certain vertex where we have no more unvisited outgoing edges.
    // Step 2). We then backtrack to the nearest neighbor vertex in the current path that has unused edges and we repeat the process until all the edges have been used.
    // first vertex that we got stuck at would be the end point of our Eulerian path. So if we follow all the stuck points backwards, we could reconstruct the Eulerian path at the end.
    public List<String> findItineraryEulersPath(List<List<String>> tickets) {
        // Step 1). build the graph first
        for(List<String> ticket : tickets) { // populate graph
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                LinkedList<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations
        this.flightMap.forEach((key, value) -> Collections.sort(value));

        this.result = new LinkedList<String>();
        // Step 3). post-order DFS
        this.DFS("JFK");
        return this.result;
    }

    protected void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (this.flightMap.containsKey(origin)) {
            LinkedList<String> destList = this.flightMap.get(origin);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        // add the airport to the head of the itinerary
        this.result.offerFirst(origin);
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
