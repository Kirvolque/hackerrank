package com.epam;

import java.util.*;

public class Solution implements Comparator<Solution.Flavor>{

    static ArrayList<Flavor> flavors;

    public static int pull (int indexOfFirst, int cost){
        int result = binarySearch(flavors, cost);
        if (result < 0) return -1;
        int i = result;
        while (i >= 0 && flavors.get(i).cost == cost && indexOfFirst < flavors.get(i).id){
            i -= 1;
        }
        return flavors.get(i + 1).id;

    }

    public static int findSecond (int money, int cost, int indexOfFirst) {
        int costOfSecond = money - cost;
        return pull(indexOfFirst, costOfSecond);
    }


    public static int binarySearch(ArrayList<Flavor> data, int value) {
        return binarySearch(data, value, 0, data.size());
    }


    private static int binarySearch(ArrayList<Flavor> data, int value, int startInclusive, int endExclusive) {
        int frameLength = endExclusive - startInclusive;
        while (frameLength > 1) {

            final int mid = startInclusive + frameLength / 2;

            if (data.get(mid).cost == value) {
                return mid;
            } else if (data.get(mid).cost > value) {
                endExclusive = mid;
            } else if (data.get(mid).cost < value) {
                startInclusive = mid + 1;
            }
            frameLength = endExclusive - startInclusive;
        }

        if (data.get(startInclusive).cost == value) {
            return startInclusive;
        } else if (data.get(startInclusive).cost < value) {
            return -(startInclusive + 1) - 1;
        }
        return -(startInclusive - 1) - 1;
    }

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
            flavors = new ArrayList<>();
            int cost;
            for(int i=0; i < n; i++){
                cost = in.nextInt();
                a[i] = cost;
                flavors.add(new Flavor(i, cost));
            }
            flavors.sort(new Solution());
            int result = 0;
            int k;
            for (k=0; k < n-1; k++){
                result = findSecond(m, a[k], k);
                if (result > 0) break;
            }
            result += 1;
            System.out.println(k + 1 + " " + result);

        }
    }
}
