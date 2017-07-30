package com.epam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution implements Comparator<Solution.Flavor>{

    @Override
    public int compare(Flavor o1, Flavor o2) {
        if(o1.cost != o2.cost) return Integer.compare(o1.cost, o2.cost);
        return (Integer.compare(o1.id, o2.id));
    }

    public static class Flavor{
        int id;
        int cost;

        Flavor(int id, int cost){
            this.id = id;
            this.cost = cost;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            List<Flavor> flavors = new ArrayList<>();
            for(int i=0; i < n; i++){
                flavors.add(new Flavor(n, in.nextInt()));
            }
            flavors.sort(new Solution());
        }
    }
}
