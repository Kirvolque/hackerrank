package com.epam;


import java.util.*;


public class Anagrams {
    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> map = new HashMap<>();
        char c;
        for (int i = 0; i < first.length(); i++) {
            c = first.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }
        for (int i = 0; i < second.length(); i++) {
            c = second.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, 1);
            }
        }

        int sum = 0;
        for (int number : map.values()) {
            sum += Math.abs(number);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

