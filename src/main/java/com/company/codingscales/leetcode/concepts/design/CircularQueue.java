package com.company.codingscales.leetcode.concepts.design;

public class CircularQueue {
    int[] arr;
    int size, currSize, head;

    public CircularQueue(int k) {
        arr = new int[k];
        head = 0; // head always points to the front. Based on size, we can point the rear.
        size = k;
        currSize = 0;
    }


    public boolean enQueue(int value) {
        if (isFull())
            return false;

        int index = (head + currSize) % size; // rear index; Incrementing the currSize will automatically change rear idx
        arr[index] = value;
        currSize++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        head = (head + 1) % size; // front index, incremented by 1 place;
        currSize--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return arr[head];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[(head + currSize - 1) % size];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == size;
    }
}
