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

    }

    private static void merge(int[] data, int startInclusive, int mid, int endExclusive, int[] additional){
        System.arraycopy(data, startInclusive, additional, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = additional[j++];
            else if (j >= endExclusive) data[k] = additional[i++];
            else if (additional[i] < additional[j]) data[k] = additional[i++];
            else data[k] = additional[j++];
        }
    }


}
