package com.epam;


import java.util.*;

public class ArraysLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] newArray = new int[n];

        for(int i = 0; i < k; i++){
            newArray[n-k+i] = a[i];
        }
        for(int j = k; j < n; j++){
            newArray[j - k] = a[j];
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output;
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }
}
