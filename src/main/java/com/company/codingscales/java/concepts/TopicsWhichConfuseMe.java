package com.company.codingscales.java.concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopicsWhichConfuseMe {
    public static void main(String[] args) {
        int[] data = new int[] {1, 2, 3, 4, 6, 7};

        // Integer

        // Converting int[] to Integer[]
        Integer[] wrapper_array = Arrays.stream(data).boxed().toArray(Integer[]::new);
        // Converting int[] to List<Integer>
        List<Integer> wrapper_array_list = Arrays.stream(data).boxed().collect(Collectors.toList());


        // Converting Integer[] to int[]
        int[] array_copy = Arrays.stream(wrapper_array).mapToInt(Integer::intValue).toArray();
        int[] array_copy_2 = Arrays.stream(wrapper_array).mapToInt(i -> i).toArray(); // Integer::intValue can be written as i -> i
        // Converting Integer[] to List<Integer>
        List<Integer> wrapper_array_list_copy = Arrays.stream(wrapper_array).collect(Collectors.toList());

        // Converting ArrayList<> to int[]
        int[] array_copy_from_al = wrapper_array_list.stream().mapToInt(Integer::intValue).toArray();
        // Converting ArrayList<> to Integer[]
        Object[] wrapper_array_copy_from_al =  wrapper_array_list.stream().mapToInt(Integer::intValue).boxed().toArray();


        // Character

        // Converting char[] to Character[]
        char[] char_data = new char[] {'a', 'b', 'c'};
        Character[] wrapper_char_array = new String(char_data).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        // Converting char[] to List<Character>
        List<Character> wrapper_char_array_list = new String(char_data).chars().mapToObj(c -> (char) c).collect(Collectors.toList());


        // Converting Character[] to char[]
        // Converting Character[] to ArrayList<Character>
            // use StringBuilder


        // Strings

        // Join ints to form a string
        String serialized = Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining("#"));
        // Join char's to form a string
        String char_serialized = new String(char_data);
        String other_way_char_to_string = String.valueOf(char_data);
        // Join Characters to form a string
            // Use StringBuilder


        // Sum of Integer[], int[], List<Integer> - Similarly you can do min, max, compare etc operations on stream
        int total1 = Arrays.stream(data).reduce(0, Integer::sum);
        int total2 = wrapper_array_list.stream().reduce(0, Integer::sum);
        int total3 = Arrays.stream(wrapper_array).reduce(0, Integer::sum);

        int maximum = Arrays.stream(data).reduce(0, Integer::max);
        int minimum = Arrays.stream(data).reduce(0, Integer::min);
        int compare = Arrays.stream(data).reduce(0, Integer::compare);

        // Sorting int[], Integer[], List<Integer>
        Arrays.sort(data);
        // Cannot reverse sort int[] -> convert to Integer[]
        Integer[] clone = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Arrays.sort(clone, Collections.reverseOrder());
        wrapper_array_list.sort((a, b) -> a - b);
        wrapper_array_list.sort(Collections.reverseOrder());
        wrapper_array_list.sort((a, b) -> b - a);
        // Sort character A
        Character[] A = serialized.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
        Arrays.sort(A, (a, b) -> {
            int x = a - 'a';
            int y = b - 'b';

            return y - x;
        });
    }
}


