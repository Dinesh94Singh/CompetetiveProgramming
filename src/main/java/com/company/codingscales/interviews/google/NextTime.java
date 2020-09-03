package com.company.codingscales.interviews.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NextTime {
    int[] hoursArr;
    int[] minutesArr;

    HashSet<Character> allowedChars;

    NextTime() {
        hoursArr = new int[24];
        minutesArr = new int[60];

        for(int i = 0; i < hoursArr.length; i++) {
            hoursArr[i] = i;
        }

        for(int i = 0; i < minutesArr.length; i++) {
            minutesArr[i] = i;
        }
    }

    private StringBuilder minHelper(int start) {
        StringBuilder res = new StringBuilder();

        for(int i = start + 1; i < minutesArr.length; i++) {
            int currMin = minutesArr[i];
            boolean containsAll = true;

            String val = String.valueOf(currMin);
            if (currMin < 10) { val = "0" + currMin; }
            for(char ch : val.toCharArray()) {
                if (!allowedChars.contains(ch)) {
                    containsAll = false;
                    break;
                }
            }

            if (containsAll) {
                if (currMin < 10) {
                    res.append(0);
                }
                res.append(currMin);

                return res;
            }
        }

        return null;
    }

    private StringBuilder hourHelper(int start) {
        StringBuilder res = new StringBuilder();

        for(int i = start + 1; i < hoursArr.length; i++) {
            int currHour = hoursArr[i];
            boolean containsAll = true;

            String val = String.valueOf(currHour);
            if (currHour < 10) { val = "0" + currHour; }
            for(char ch : val.toCharArray()) {
                if (!allowedChars.contains(ch)) {
                    containsAll = false;
                    break;
                }
            }

            if (containsAll) {
                if (currHour < 10) {
                    res.append(0);
                }
                res.append(currHour);
                res.append(":");
                return res;
            }
        }

        return hourHelper(-1);
    }

    public String nextClosestTimeBruteForce(String time) {
        // the only allowed chars are from the time
        String[] segments = time.split(":");

        int hours = Integer.parseInt(segments[0]);
        int minutes = Integer.parseInt(segments[1]);

        allowedChars = new HashSet<>();

        for(char ch : time.toCharArray()) {
            if (ch != ':')
                allowedChars.add(ch);
        }

        StringBuilder res = minHelper(minutes);

        if (res == null) {
            res = hourHelper(hours);
            res.append(minHelper(-1));
            return res.toString();
        } else {
            res.insert(0, ":");
            res.insert(0, hours);
            if (hours < 10) {
                res.insert(0, 0);
            }
            return res.toString();
        }
    }

    Integer res;
    private void recHelper(List<Integer> al, Set<Integer> hs) {
        if (al.size() == 4) {
            String s = al.stream().map(String::valueOf).collect(Collectors.joining(""));
            int hours = Integer.parseInt(s.substring(0, 3));
            int minutes = Integer.parseInt(s.substring(2));

            if (0<=hours && hours <=23 && 0 <=minutes && minutes <=59) {
                res = Math.min(hours * 60 + minutes, res);
            }
            return;
        }

        for(Integer each : hs) {
            al.add(each);
            recHelper(al, hs);
            al.remove(al.size() - 1);
        }
    }

    public String nextClosestTime(String time) {
        // backtracking
        Set<Integer> hs = new HashSet<>();
        res = Integer.MAX_VALUE;
        for(char ch : time.toCharArray()) {
            hs.add(Character.getNumericValue(ch));
        }

        recHelper(new ArrayList<Integer>(), hs);
        if (res == Integer.MAX_VALUE) { return ""; }

        int hours = res / 60;
        int minutes = res % 60;

        return hours + ":" + minutes;
    }

    public static void main(String[] args) {
        NextTime nxtTime = new NextTime();
//        System.out.println(nxtTime.nextClosestTime("19:34"));
//        System.out.println(nxtTime.nextClosestTime("23:59"));
        System.out.println(nxtTime.nextClosestTime("01:32"));
    }
}
