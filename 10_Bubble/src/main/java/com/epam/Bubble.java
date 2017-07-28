package com.epam;

import java.util.Scanner;

public class Bubble {

    private static void swap(int a, int b, int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void sort(int[] a){
        int numberOfSwaps = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal


            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.printf("Array is sorted in %d swaps.%n", numberOfSwaps);
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);


    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        sort(a);

    }


}
