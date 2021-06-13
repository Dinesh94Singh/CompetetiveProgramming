package com.company.codingscales.leetcode.concepts.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Employee {
        int idx;
        int intervalIdx;
        Interval interval;

        Employee(int idx, int intervalIdx, Interval interval) {
            this.idx = idx;
            this.intervalIdx = intervalIdx;
            this.interval = interval;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // given list of all employees, working periods
        // find a common free time for these employees

        // intervals of each person are already in sorted order

        // priority queue
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Employee> pq = new PriorityQueue<>((a, b) -> {
            if (a.interval.start != b.interval.start) {
                return a.interval.start - b.interval.start;
            } else if (a.interval.end != b.interval.end) {
                return a.interval.end - b.interval.end;
            } else {
                return a.idx - b.idx;
            }
        });

        for(int i = 0; i < schedule.size(); i++) {
            List<Interval> eachEmp = schedule.get(i);
            Interval currInterval = eachEmp.get(0);
            Employee e = new Employee(i, 0, currInterval);
            pq.offer(e);
        }

        Interval interval = pq.peek().interval;

        while (!pq.isEmpty()) {
            Employee currEmp = pq.poll();
            Interval currInterval = currEmp.interval;

            // Check for overlap
            if (interval.end < currInterval.start) {
                // there is some gap left between the two - Add to res
                Interval t = new Interval(interval.end, currInterval.start);
                res.add(t);

                interval = currInterval;
            } else if (interval.end < currInterval.end) {
                // overlap, so no free time
                interval = currInterval;
            }

            // Add the new Employee
            if (currEmp.intervalIdx + 1 < schedule.get(currEmp.idx).size()) {
                Employee upcomingEmployee = new Employee(currEmp.idx, currEmp.intervalIdx + 1, schedule.get(currEmp.idx).get(currEmp.intervalIdx + 1));
                pq.offer(upcomingEmployee);
            }
        }

        return res;
    }

}
