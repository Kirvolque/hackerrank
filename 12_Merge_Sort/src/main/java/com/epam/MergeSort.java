package com.epam;

//import java.util.Scanner;

//import static com.epam.MergeSort.merge;

public class MergeSort {

    public static int swaps;

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int n = in.nextInt();
//            int arr[] = new int[n];
//            for(int arr_i=0; arr_i < n; arr_i++){
//                arr[arr_i] = in.nextInt();
//            }
//            sort(arr, n);
//        }

        int [] arr = {1, 1 ,1, 2, 2};
        sort (arr, 5);

    }

    public static void sort(int[] data, int size) {
        swaps = 0;
        mergeSortDown(data, 0, size, new int[size]);
        System.out.println(swaps);
    }

    private static void mergeSortDown(int[] data, int startInclusive, int endExclusive, int[] additional) {

        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length / 2;
        mergeSortDown(data, startInclusive, mid, additional);
        mergeSortDown(data, mid, endExclusive, additional);

        merge(data, startInclusive, mid, endExclusive, additional);
    }

    private static void merge(int[] data, int startInclusive, int mid, int endExclusive, int[] additional){
        System.arraycopy(data, startInclusive, additional, startInclusive, endExclusive - startInclusive);
        int i = startInclusive;
        int j = mid;
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
    }

}
