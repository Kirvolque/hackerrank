package com.epam;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            sort(arr, n);
        }

    }

    public static void sort(int[] data, int size) {

        System.out.println(mergeSortDown(data, 0, size, new int[size]));
    }

    private static long mergeSortDown(int[] data, int startInclusive, int endExclusive, int[] additional) {

        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return 0;
        }

        final int mid = startInclusive + length / 2;

        long swaps = 0L;
        swaps += mergeSortDown(data, startInclusive, mid, additional);
        swaps += mergeSortDown(data, mid, endExclusive, additional);

        swaps += merge(data, startInclusive, mid, endExclusive, additional);

        return swaps;
    }

    private static long merge(int[] data, int startInclusive, int mid, int endExclusive, int[] additional){
        System.arraycopy(data, startInclusive, additional, startInclusive, endExclusive - startInclusive);
        int i = startInclusive;
        int j = mid;
        long swaps = 0L;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid){
                data[k] = additional[j++];
            }
            else if (j >= endExclusive){
                data[k] = additional[i++];

            }
            else if (additional[i] <= additional[j]){
                data[k] = additional[i++];
            }

            else {
                swaps += mid - i;
                data[k] = additional[j++];
            }
        }
        return swaps;
    }


}
