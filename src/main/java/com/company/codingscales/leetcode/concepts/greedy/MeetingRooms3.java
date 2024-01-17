package com.company.codingscales.leetcode.concepts.greedy;

import java.util.*;

class Meeting {
    int start;
    int end;
    int meetingRoomNo;

    Meeting(int s, int e, int m) {
        this.start = s;
        this.end = e;
        this.meetingRoomNo = m;
    }
}

public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] counts = new int[n];

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<Meeting> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a.end != b.end) {
                return a.end - b.end; // what ever ends first
            }

            return a.meetingRoomNo - b.meetingRoomNo;
        });

        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (occupiedRooms.size() > 0 && occupiedRooms.peek().end <= start) {
                Meeting meeting = occupiedRooms.poll();
                freeRooms.add(meeting.meetingRoomNo);
            }

            if (freeRooms.size() > 0) {
                // no need to wait
                int meetingRoomNo = freeRooms.poll();
                counts[meetingRoomNo]++;
                occupiedRooms.add(new Meeting(start, end, meetingRoomNo));
            } else {
                // need to wait
                Meeting m = occupiedRooms.poll();

                int delay = m.end - start;
                counts[m.meetingRoomNo]++;
                occupiedRooms.offer(new Meeting(start + delay, end + delay, m.meetingRoomNo));
            }
        }

        int max = 0;
        int res = 0;
        for(int i = 0; i < counts.length; i++) {
            if (max < counts[i]) {
                res = i;
                max = counts[i];
            }
        }

        return res;
    }
}

