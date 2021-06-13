package com.company.codingscales.contests;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2 {
    class LocationDate {
        String photoName;
        String extension;
        String location;
        Date date;

        LocationDate(String location, String extension, String photoName, Date date) {
            this.location = location;
            this.extension = extension;
            this.photoName = photoName;
            this.date = date;
        }

        public int compare(final Object o1, final Object o2) {
            LocationDate curr = (LocationDate) o1;
            LocationDate other = (LocationDate) o2;

            return curr.date.compareTo(other.date);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(location);
            sb.append("\n");

            return sb.toString();
        }
    }

    public String solve(String text) {
        String[] lines = text.split("\\n");

        HashMap<String, PriorityQueue<LocationDate>> map = new HashMap<String, PriorityQueue<LocationDate>>();

        for (String eachLine : lines) {
            String[] details = eachLine.split(",");
            String[] subDetails = details[0].split(".");
            String photoName = subDetails[0];
            String extension = subDetails[1];
            String location = details[1];
            String dateTime = details[2];

            map.putIfAbsent(location, new PriorityQueue<>());
            System.out.println(new Date(dateTime));
            map.get(location).add(new LocationDate(location, extension, photoName, new Date(dateTime)));
        }

        for (Map.Entry<String, PriorityQueue<LocationDate>> entries : map.entrySet()) {
            PriorityQueue<LocationDate> locationDates = entries.getValue();
            int size = locationDates.size();
            String requiredLength = "" + size;
            int parsedLength = Integer.parseInt(requiredLength);

            List<LocationDate> arrList = new ArrayList<>(entries.getValue()); // duplicates available
            locationDates.clear();
            for (int i = 0; i < arrList.size(); i++) {
                String digitLength = "" + i;
                LocationDate ld = arrList.get(i);
                ld.location = ld.location + padExtras(size - digitLength.length()) + i;
                locationDates.add(ld);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String eachLine : lines) {
            String[] details = eachLine.split(",");
            String location = details[1];

            PriorityQueue<LocationDate> pq = map.getOrDefault(location, new PriorityQueue<>());

            if (pq.isEmpty())
                return ""; // should never be here

            LocationDate ld = pq.poll();
            sb.append(ld.toString());
        }

        return sb.toString();
    }

    private static String padExtras(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append("0");

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
