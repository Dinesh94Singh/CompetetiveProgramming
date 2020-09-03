package com.company.codingscales.standardAlgorithms;

import java.util.*;
import java.lang.*;

/**
 * O(ELogV + VLogV) => ELogV for relax and LogV to extract min, V for iterating over all the elements
 *
 * In java & c++ for decrease key operation / extract min, in order to do it log timecomplexity, you have to delete and add the updated value like done in Prims algorithm, which is not implemented as part of this algorithm.
 */
public class DijkstrasWithPQ {
    // Class to represent a node in the graph
    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(final int node, final int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(final Node node1, final Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    private final int[] dist;
    private final Set<Integer> settled;
    private final PriorityQueue<Node> pq;
    private final int V; // Number of vertices
    List<List<Node>> adj;

    public DijkstrasWithPQ(final int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Function for Dijkstra's Algorithm
    public void dijkstra(final List<List<Node>> adj, final int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            final int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            relax(u);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void relax(final int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            final Node v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    // Driver code
    public static void main(final String[] arg) {
        final int V = 5;
        final int source = 0;

        // Adjacency list representation of the
        // connected edges
        final List<List<Node>> adj = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            final List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        final DijkstrasWithPQ dpq = new DijkstrasWithPQ(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is " + dpq.dist[i]);
    }
}
