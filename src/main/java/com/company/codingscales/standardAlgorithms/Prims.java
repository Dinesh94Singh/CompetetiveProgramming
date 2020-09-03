package com.company.codingscales.standardAlgorithms;

// Java program for Prim's MST for
// adjacency list representation of graph

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Prims {
    class AdjListNode {

        // Stores destination vertex in adjacency list
        int dest;

        // Stores weight of a vertex in the adjacency list
        int weight;

        // Constructor
        AdjListNode(final int a, final int b) {
            dest = a;
            weight = b;
        }
    }

    static class Graph {

        // Number of vertices in the graph
        int V;

        // List of adjacent nodes of a given vertex
        LinkedList<AdjListNode>[] adj;

        // Constructor
        Graph(final int e) {
            V = e;
            adj = new LinkedList[V];
            for (int o = 0; o < V; o++)
                adj[o] = new LinkedList<>();
        }
    }

    // class to represent a node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    class GraphNode {
        int vertex;
        int key;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if curr.key > other.key
    // returns -1 if curr.key < other.key and
    // returns 0 otherwise
    class  comparator implements Comparator<GraphNode> {

        @Override
        public int compare(final GraphNode curr, final GraphNode other) {
            return curr.key - other.key;
        }
    }

    // method to add an edge
    // between two vertices
    void addEdge(final Graph graph, final int src, final int dest, final int weight) {

        final AdjListNode curr = new AdjListNode(dest, weight);
        final AdjListNode node = new AdjListNode(src, weight);
        graph.adj[src].addLast(curr);
        graph.adj[dest].addLast(node);
    }

    // method used to find the mst
    void prims_mst(final Graph graph) {
        // Whether a vertex is in PriorityQueue or not
        final Boolean[] mstset = new Boolean[graph.V];
        final GraphNode[] vertices = new GraphNode[graph.V];

        // Stores the parents of a vertex
        final int[] parent = new int[graph.V];

        for (int i = 0; i < graph.V; i++) {
            mstset[i] = false; // Initialize to false

            vertices[i] = new GraphNode();
            vertices[i].key = Integer.MAX_VALUE; // Initialize key values to infinity
            vertices[i].vertex = i;
            parent[i] = -1;
        }

        // Include the source vertex in mstset
        mstset[0] = true;

        // Set key value to 0
        // so that it is extracted first
        // out of PriorityQueue
        vertices[0].key = 0;

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        final TreeSet<GraphNode> queue = new TreeSet<GraphNode>(new comparator());

        for (int i = 0; i < graph.V; i++)
            queue.add(vertices[i]); // add all the other vertices into the queue

        // Loops until the queue is not empty
        while (!queue.isEmpty()) {
            // Extracts a node with min key value
            final GraphNode curr = queue.pollFirst();
            mstset[curr.vertex] = true; // mark that the node is no longer present in the queue

            // For all adjacent vertex of the extracted vertex V
            for (final AdjListNode iterator : graph.adj[curr.vertex]) {
                // If V is in queue
                // If the key value of the adjacent vertex is more than the extracted key update the key value of adjacent vertex
                if (mstset[iterator.dest] == false && vertices[iterator.dest].key > iterator.weight) {
                    queue.remove(vertices[iterator.dest]); // remove to update
                    vertices[iterator.dest].key = iterator.weight;
                    queue.add(vertices[iterator.dest]); // update with iterator.weights value
                    parent[iterator.dest] = curr.vertex;
                }
            }
        }

        // Prints the vertex pair of mst
        for (int i = 1; i < graph.V; i++)
            System.out.println(parent[i] + " " + "-" + " " + i);
    }

    public static void main(final String[] args) {
        final int V = 9;

        final Graph graph = new Graph(V);

        final Prims e = new Prims();

        e.addEdge(graph, 0, 1, 4);
        e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.prims_mst(graph);
    }
}


