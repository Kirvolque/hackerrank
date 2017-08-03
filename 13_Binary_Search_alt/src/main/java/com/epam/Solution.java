package com.epam;

import java.util.*;

public class Solution{

    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            map = new HashMap<>();
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n + 1];
            int cost;
            for (int i = 1; i <= n; i++) {
                cost = in.nextInt();
                a[i] = cost;
                map.put(cost, i);
            }
            int k;
            for (k = 1; k <= n; k++) {
                if (map.containsKey(m - a[k]) && map.get(m - a[k]) != k) {
                    break;
                }
            }
            System.out.println(k + " " + map.get(m - a[k]));
        }
    }
}
