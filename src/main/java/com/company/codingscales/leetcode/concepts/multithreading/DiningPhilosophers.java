package com.company.codingscales.leetcode.concepts.multithreading;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private ReentrantLock[] mutexes;

    public DiningPhilosophers() {
        this.mutexes = new ReentrantLock[5];
        for (var i = 0; i < 5; i ++) {
            this.mutexes[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(
            int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat, Runnable putLeftFork, Runnable putRightFork
    ) throws InterruptedException {
        var forkNumbers = new int[] {philosopher, (philosopher + 1) % 5};
        Arrays.sort(forkNumbers);

        this.mutexes[forkNumbers[0]].lock();
        this.mutexes[forkNumbers[1]].lock();
        eat(pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        this.mutexes[forkNumbers[1]].unlock();
        this.mutexes[forkNumbers[0]].unlock();
    }

    private void eat(Runnable ... actions) {
        for (var action : actions) {
            action.run();
        }
    }
}
