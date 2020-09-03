package com.company.codingscales.leetcode.concepts.greedy;

import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(final int _start, final int _end) {
        start = _start;
        end = _end;
    }
}

public class EmployeeFreeTime {
    class Employee {
        int index;
        int intervalIndex;
        Interval interval;

        Employee() {}
        Employee(final int index, final int intervalIndex, final Interval interval) {
            this.index = index;
            this.intervalIndex = intervalIndex;
            this.interval = interval;
        }
    }

    // given intervals are already for employees -> Add the first interval of all the employees into heap?
    // heap is sorted based on start interval and end intervals
    // rinse and repeat until heap size is 1, given input is guaranteed to not contain res which has 0 free time.
    public List<Interval> employeeFreeTime(final List<List<Interval>> schedule) {
        final List<Interval> res = new ArrayList<>();
        final PriorityQueue<Employee> heap = new PriorityQueue<Employee>((curr, other) -> {
            if (curr.interval.start != other.interval.start) {
                return curr.interval.start - other.interval.start;
            } else if (curr.interval.end != other.interval.end) {
                return curr.interval.end - other.interval.end;
            }
            return curr.index - other.index;
        });
        for(int i = 0; i < schedule.size(); i++) {
            final Interval temp = schedule.get(i).get(0);
            heap.offer(new Employee(i, 0, temp));
        }

        Interval prevInterval = heap.peek().interval;

        while(!heap.isEmpty()) {
            final Employee e = heap.poll();
            final Interval curr = e.interval;

            if (prevInterval.end < curr.start) {
                res.add(new Interval(prevInterval.end, curr.start));
                prevInterval = curr;
            } else if (prevInterval.end < curr.end) {
                // starts are already sorted because of pq's priority logic
                // there is no chance with prevInterval, if prevInterval ends later, then prevInterval has better chance to find the free time
                prevInterval = curr;
            }

            if (e.intervalIndex + 1 < schedule.get(e.index).size()) {
                e.interval = schedule.get(e.index).get(e.intervalIndex + 1);
                e.intervalIndex++;
                heap.offer(e);
            }
        }
        return res;
    }

    public static void main(final String[] args) {
        // [[[1,2],[5,6]],[[1,3]],[[4,10]]]
        final List<List<Interval>> input = new ArrayList<>();
        final List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 2));
        intervals1.add(new Interval(5, 6));
        final List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 3));
        intervals2.add(new Interval(4, 10));

        input.add(intervals1);
        input.add(intervals2);

        final EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        employeeFreeTime.employeeFreeTime(input);
    }

}
