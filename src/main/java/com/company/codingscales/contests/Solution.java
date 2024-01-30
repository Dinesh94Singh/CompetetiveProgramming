package com.company.codingscales.contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Solution {

    // Request Object
    class Request {
        long timeInSec;// or Date/Instant
        int numberOfRequest;

        public long getTimeInSec() {
            return timeInSec;
        }

        public int getNumberOfRequests() {
            return numberOfRequest;
        }

        public void setTime(long timeInSec, int numberOfRequest) {
            this.timeInSec = timeInSec;
            this.numberOfRequest = numberOfRequest;
        }

        public String toString() {
            return " timeInSec = " + this.timeInSec + " , numberOfReqs = " + this.numberOfRequest;
        }
    }

    static long timeStamp = 0;

    private static long getTimeStamp() {
        timeStamp++;

        return timeStamp;
    }

    Map<String, List<Request>> map = new ConcurrentHashMap<String, List<Request>>();// source or user is key, request as
                                                                                    // value map

    public static void main(String[] args) {

        /**
        {
            "A": [{req1, x_ts}, {req3, y_ts}]
            "B": [],
        }

        // milliseconds as a factor - System.getCurrentMillis() -> milliseconds - Support implemented

        // Main Thread - pause/resume of threads is not controllable
            // s.rateLimit() -> 10sec ts
            // s.rateLimit() -> 10sec ts
            // Thread.sleep(1000s) => meaning 1 sec => doesn't guarantee it to be precisely 1 sec it culd be 1sec or 3 sec or 5 sec., depends on m/c
        */

        // abstract info of ts - 0
        // s.rateLimit() -> 1sec ts
        // s.rateLimit() -> 2sec ts

        // to similate 30 sec have passed - timeStamp += 30 => Thread.sleep(3 * 1000) => doesn't guarantee to be preciesly 30 secs



        // Returns false

        Solution s = new Solution();

        /** {
            "1432" : [{0, 1}, {1,1}, {2,1}] // when {3, 1} - return true - getting rate-limited
        } **/

        System.out.println(s.rateLimit("my_device_1432", 30, 3)); // false
        System.out.println(s.rateLimit("my_device_1432", 30, 3)); // false
        System.out.println(s.rateLimit("my_device_1432", 30, 3)); // false
        System.out.println(s.rateLimit("my_device_1432", 30, 3)); // true - Rate limited by maxLimit within last 30
                                                                  // sec

        // In 1 sec interval, the limit is refreshed. To see ratelimiting

        /** {
            "1433" : [{4, 1}, {5, 1}, {6, 1}, {7, 1}]
        } **/
        System.out.println(s.rateLimit("my_device_1433", 1, 3)); // false
        System.out.println(s.rateLimit("my_device_1433", 1, 3)); // false
        System.out.println(s.rateLimit("my_device_1433", 1, 3)); // false
        System.out.println(s.rateLimit("my_device_1433", 1, 3)); // false


        System.out.println(s.rateLimit("my_device_1434", 1, 1)); // false 8
        System.out.println(s.rateLimit("my_device_1434", 1, 1)); // false 9
        System.out.println(s.rateLimit("my_device_1434", 1, 1)); // false 10
        System.out.println(s.rateLimit("my_device_1434", 1, 1)); // false 11

        // Move forward in time by 30 sec in each request


        /** {
            1435 - [{12, 1], {42, 1}} 42 - 12 => 30 (before 30)
        } **/
        System.out.println(s.rateLimit("my_device_1435", 300, 1)); // false
        timeStamp += 30; // ts - 42
        System.out.println(s.rateLimit("my_device_1435", 300, 1)); // true // time passed is only 30 sec, 300 sec
                                                                   // intervals with max requests allowed 1 - so

        // ts - 43                                                           // rate-limited
        timeStamp += 30; // ts - 73 - 42 =? 31
        System.out.println(s.rateLimit("my_device_1435", 300, 1)); // true
        timeStamp += 30;
        System.out.println(s.rateLimit("my_device_1435", 300, 1)); // true

        timeStamp += 300;
        System.out.println(s.rateLimit("my_device_1435", 300, 1)); // false = more than 300 sec have passed. It is
                                                                   // considered as a fresh request and should not be
                                                                   // rate-limited
    }

    // 1432 30 sec 3
    // 1432 20 sec

    public boolean rateLimit(String key, int intervalInfoInSec, int maxLimit) {
        // System.out.println(map);
        long currentTimeStamp = getTimeStamp();

        // Return 'true' if no more requests are allowed, and 'false' otherwise
        if (map.containsKey(key)) {
            // existing user / source so calculate total number of requests and validation
            List<Request> currentNbrOfRequests = map.get(key);
            int total = getTotalRequestsOfSource(key);// gives the total number of requests of a user/source

            if (total < maxLimit) {
                Request r = new Request();
                r.setTime(currentTimeStamp, 1);
                currentNbrOfRequests.add(r);

                // as total is less than the maximum allowed returning here as false;
                return false;
            } else {
                int count = 0;
                for (Request r : currentNbrOfRequests) {
                    long diff = currentTimeStamp - r.getTimeInSec();

                    if (diff < intervalInfoInSec) {
                        count++;
                    }

                    if (count >= maxLimit) { // rate-limited
                        return true;
                    }
                }

                return false;
            }
        } else {
            // new user / source
            if (maxLimit < 1) {
                return false;
            }

            List<Request> list = new ArrayList<Request>();
            Request r = new Request();
            r.setTime(currentTimeStamp, 1);
            list.add(r);
            map.put(key, list);

            return false;
        }
    }

    // utility method to get total requests of specific user
    public int getTotalRequestsOfSource(String key) {
        List<Request> userRequests = map.get(key);
        int total = 0;
        for (Request r : userRequests) {
            total += r.getNumberOfRequests();
        }
        return total;
    }
}
