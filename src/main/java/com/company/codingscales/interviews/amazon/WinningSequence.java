package com.company.codingscales.interviews.amazon;

// Not sure, if this works
public class WinningSequence {
    static int[] winningSequence(int n, int le, int ue) {
        int start = ue - 1;
        int[] res = new int[n];
        int N = n;
        int i = 0;

        while (start <= ue && n > 0) {
            res[i] = start;
            i++;
            start++;
            n--;
        }

        start = ue - 1;
        while(start >= le && n > 0) {
            res[i] = start;
            i++;
            start--;
            n--;
        }

        if (i != N)
            return new int[]{-1};
        return res;
    }

    public static void main(String[] args) {
        int[] arr = winningSequence(5, 3, 10);
        for(int a: arr)
            System.out.printf("%d \t", a);
        arr = winningSequence(100, 3, 10);
        arr = winningSequence(10, 9, 10);
        System.out.println("Done !!");
    }

}
