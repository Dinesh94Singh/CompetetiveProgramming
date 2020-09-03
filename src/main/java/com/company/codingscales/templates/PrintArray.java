package com.company.codingscales.templates;

import java.util.List;

public class PrintArray {
    public static void printArray(final int[] t) {
        for(final int a: t) {
            System.out.print(a + "\t");
        }
        System.out.println("\n");
    }

    public static <T> void printArray(final T[] t) {
        for(final T a: t) {
            System.out.print(a + "\t");
        }
        System.out.println("\n");
    }

    public static <T> void printArrayList(final List<T> t) {
        for(final T a: t) {
            System.out.println(a);
        }
    }
}
