package com.epam;

import java.util.Scanner;

public class Solution {

    public static long makeChange(int[] coins, int money) {
        long[] d = new long[money + 1];
        for(int coin : coins) {
            for(int j = coin; j < d.length; j++) {
                d[j] += d[j - coin];
            }
        }
        return d[money];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
