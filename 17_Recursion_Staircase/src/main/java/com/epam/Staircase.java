package com.epam;

import java.util.Scanner;

public class Staircase {

    static int[] count;

    public static int calculateWaysOfClimpbing(int n){
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;


        int sum = 0;
        if (count[n - 1] != 0){
            return count[n - 1];
        }
        for (int k = 1; k <= 3; k++){
            sum += calculateWaysOfClimpbing(n - k);
        }
        count[n - 1] = sum;
        return sum;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            count = new int[n];
            System.out.println(calculateWaysOfClimpbing(n));
        }
    }
}
