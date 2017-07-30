package com.epam;

import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(findUnique(a));
    }

    public static int findUnique(int[] a){
        int num = a[0];
        for (int i=1; i < a.length; i++){
            num ^= a[i];
        }
        return num;
    }



}
