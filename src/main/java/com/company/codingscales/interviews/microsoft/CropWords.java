package com.company.codingscales.interviews.microsoft;

public class CropWords {
    private static String cropWords(final String s, int k) {
        if(k >= s.length()){
            return s;
        }
        final StringBuilder sb = new StringBuilder(s.substring(0, k));
        if(s.charAt(k) != ' '){
            while(sb.charAt(--k) != ' '){
                sb.deleteCharAt(k);
            }
        }
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(final String[] args) {
        System.out.println(cropWords("codility We test coders", 14));// === "codility We"
        System.out.println(cropWords(" co de my", 5));// === " co"
        System.out.println(cropWords(" co de my", 7));// === " co de"
        System.out.println(cropWords("   ", 2));// === ""
        System.out.println(cropWords("   re", 2));// === "") //3 spaces before
        System.out.println(cropWords(" c ", 3));// === " c"
        System.out.println(cropWords(" c d  ", 5));// === " c d"
        System.out.println(cropWords("co de my", 5));// === "co de"
        System.out.println(cropWords("Word", 4));// === "Word"
        System.out.println(cropWords("codility We test coders", 23));// === "codility We test coders"
        System.out.println(cropWords("withOutSpaces", 14));// === "withOutSpaces"
        System.out.println(cropWords("", 14));// === ""
        System.out.println(cropWords("Separatedby hyphens", 14));// === "Separatedby"
        System.out.println(cropWords("      Codility We test coders     ", 14));// === "      Codility") //6 leading spaces
        System.out.println(cropWords("      Codility We test coders     ", 10));// === "") //6 leading spaces
    }
}
