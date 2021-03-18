package com.company.codingscales.leetcode.concepts.design;

import java.util.HashMap;

// Doesn't work since, the problem solves a different set of requirements, but the DS should be the same for LFU Cache.
public class LFUCache {
    static class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
    }

    static class DLL {
        Node head;
        Node tail;
        int size;

        DLL() {
            size = 0;
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }
    }

    HashMap<Integer, DLL> freqToDLL = new HashMap<>();
    HashMap<Integer, Node> keyToNode = new HashMap<>();
    int size = 0;
    int minFreq = 0;
    int capacity;

    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private void removeNode(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;
    }

    private void removeNodeFromFreq(Node n, int f) {
        removeNode(n);

        if (minFreq == n.freq) {
            minFreq = n.freq + 1;
        }

        DLL dll = freqToDLL.get(f);
        if (dll.size == 1) {
            freqToDLL.remove(f);
        } else {
            dll.size--;
        }
    }

    private void moveToHead(DLL list, Node n) {
        Node head = list.head;
        Node next = head.next;

        n.next = next;
        next.prev = n;

        head.next = n;
        n.prev = head;
    }

    private void addNodeToFreqMap(Node n, int f) {
        if (!freqToDLL.containsKey(f)) {
            freqToDLL.put(f, new DLL());
        }

        DLL doublyList = freqToDLL.get(f);
        doublyList.size++;
        moveToHead(doublyList, n);
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key))
            return -1;

        Node curr = keyToNode.get(key);
        int currFreq = curr.freq;
        int updatedFreq = currFreq + 1;

        removeNodeFromFreq(curr, currFreq);
        addNodeToFreqMap(curr, updatedFreq);
        curr.freq = updatedFreq;
        return curr.val;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node curr = keyToNode.get(key);
            curr.val = value;

            int currFreq = curr.freq;
            int updateFreq = currFreq + 1;
            curr.freq = updateFreq;
            removeNodeFromFreq(curr, currFreq);
            addNodeToFreqMap(curr, updateFreq);
        } else {
            if (size == capacity) {
                DLL dll = freqToDLL.get(minFreq); // minFreq might not be always 1

                Node prev = dll.tail.prev;
                removeNode(prev);
                keyToNode.remove(prev.key);
                if (dll.size == 0) {
                    freqToDLL.remove(minFreq);
                }
                size--;
            }

            Node curr = new Node();
            curr.key = key; curr.val = value; curr.freq = 1; minFreq = 1; // it should always be 1
            addNodeToFreqMap(curr, minFreq);
            keyToNode.put(key, curr);
            size++;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println(cache.get(3)); // 3
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
