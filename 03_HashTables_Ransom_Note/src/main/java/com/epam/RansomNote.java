package com.epam;
import java.util.*;

public class RansomNote {



    public static String solve (Map<String, Integer> magazine, String[] ransom) {
        String word;
        for (int i=0; i<ransom.length; i++){
            word = ransom[i];
            if(magazine.containsKey(word) && magazine.get(word) > 0){
                magazine.put(word, magazine.get(word) - 1);
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<String, Integer> magazine = new HashMap<>();
        String word;

        for(int magazine_i=0; magazine_i < m; magazine_i++) {
            word = in.next();
            if (magazine.containsKey(word)) {
                magazine.put(word, magazine.get(word) + 1);
            } else {
                magazine.put(word, 1);
            }
        }


        String[] ransom = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            word = in.next();
            ransom[ransom_i] = word;
        }

        System.out.println(solve(magazine, ransom));

    }

}
