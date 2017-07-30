package com.epam;

import java.util.Scanner;

public class Staircase {



    public static int calculateWaysOfClimpbing(int n){
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;

        int sum = 0;
        for (int k = 1; k <= 3; k++){
            sum += calculateWaysOfClimpbing(n - k);
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            //calculateWaysOfClimpbing(n, 0, n);
            System.out.println(calculateWaysOfClimpbing(n));
        }
    }
}
