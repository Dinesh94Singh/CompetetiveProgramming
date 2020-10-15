package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMarks {
    public int hishestAverage(String[][] scores) {
        if(scores == null || scores.length == 0) {
            return -1;
        }
        int highestAve = 0;
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < scores.length; i++) {
            List<Integer> scoreList = map.get(scores[i][0]);
            if(scoreList == null) {
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            } else {
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }

        //go through the map. find the largest ave
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int currentAveScore = aveCalculate(entry.getValue());

            highestAve = Math.max(highestAve, currentAveScore);
        }

        return highestAve;
    }

    private int aveCalculate(List<Integer> scores) {
        int len = scores.size();
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }

        return sum / len;
    }
}
