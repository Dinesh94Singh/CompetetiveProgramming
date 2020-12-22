package com.company.codingscales.interviews.microsoft;

public class PatternMatching {
    /**
     * 		String[] sp = s.split(";");
     * 		String patter = sp[0];
     * 		String[] sample = sp[1].split("\\|");
     * 		StringBuilder sb = new StringBuilder();
     * 		int sum = 0;
     * 		for(int i = 0; i < sample.length; i++) {
     * 			int count = 0;
     * 			for(int j = 0; j < sample[i].length() - patter.length() + 1; j++) {
     * 				if(!patter.isEmpty() && patter.equals(sample[i].substring(j,j+patter.length()))) {
     * 					count++;
     *              }
     *          }
     * 			sum += count;
     * 			sb.append(count+"|");
     *        }
     * 		sb.append(sum);
     * 		return sb.toString();
     */
    public String patternMatching(String input) {
        if (input == null || input.isEmpty()) return "";
        String[] inputs = input.split(";");
        String pattern = inputs[0];
        String[] blobs = inputs[1].split("\\|");
        StringBuffer sb = new StringBuffer();
        int global_counter = 0;
        for (String blob : blobs) {
            int count = 0;
            if (pattern != null && !pattern.isEmpty())
                count = patternCount(pattern, blob);
            global_counter += count;
            sb.append(String.valueOf(count + "|"));
        }

        sb.append(global_counter);
        return sb.toString();
    }

    private int patternCount(String patter, String blob) {
        int count = 0, last_index = 0;
        while (last_index != -1) {
            last_index = blob.indexOf(patter, last_index);
            if (last_index != -1) {
                last_index += patter.length();
                count += 1;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        PatternMatching s = new PatternMatching();
        System.out.println(s.patternMatching("bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        System.out.println(s.patternMatching("b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        System.out.println(s.patternMatching(";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
    }
}
