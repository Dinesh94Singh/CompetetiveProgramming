package com.company.codingscales.interviews.microsoft;

public class PatternRecognization {
    public static String reco(String s) {
        String[] sp = s.split(";");
        String patter = sp[0];
        String[] sample = sp[1].split("\\|");
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < sample.length; i++) {
            int count = 0;
            for(int j = 0; j < sample[i].length() - patter.length() + 1; j++) {
                if(!patter.isEmpty() && patter.equals(sample[i].substring(j,j+patter.length()))) {
                    count++;
                }
            }
            sum += count;
            sb.append(count+"|");
        }
        sb.append(sum);
        return sb.toString();
    }
}
