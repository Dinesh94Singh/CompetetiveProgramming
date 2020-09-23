package com.company.codingscales.leetcode.concepts.design;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        Node prev;
        Node nxt;
        int key;
        int value;

        Node() {
            prev = null;
            nxt = null;
        }
    }

    HashMap<Integer, Node> keyToNode;
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyToNode = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.nxt = tail;
        tail.prev = head;
    }

    private void moveToHead(final Node n) {
        if (n == null)
            return;

        final Node curr = this.head.nxt;
        this.head.nxt = n;
        n.prev = this.head;
        n.nxt = curr;
        if (curr != null)
            curr.prev = n;
    }

    private void remove(final Node n) {
        if (n.prev != null)
            n.prev.nxt = n.nxt;
        if (n.nxt != null)
            n.nxt.prev = n.prev;
    }

    public int get(final int key) {
        if(!keyToNode.containsKey(key))
            return -1; // key value not present
        final Node n = keyToNode.get(key);
        this.remove(n);
        this.moveToHead(n);
        return n.value;
    }

    public void put(final int key, final int value) {
        final Node n;
        if (keyToNode.containsKey(key)) {
            n = keyToNode.get(key);
            n.value = value;
            this.remove(n);
        } else {
            if (this.size == this.capacity) {
                this.keyToNode.remove(this.tail.prev.key);
                this.remove(this.tail.prev);
                this.size -= 1;
            }
            n = new Node();
            n.key = key;
            n.value = value;
            this.size += 1;
        }
        this.moveToHead(n);
        keyToNode.put(key, n);
    }

    public static void main(final String[] args) {
        final LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }
}

