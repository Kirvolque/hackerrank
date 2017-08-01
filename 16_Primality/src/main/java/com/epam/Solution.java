package com.epam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        String answer;
        for(int a0 = 0; a0 < p; a0++){
            answer = "Prime";
            int n = in.nextInt();

            for (int l = 2; l <= Math.sqrt(n); l++){
                if (n % l == 0){
                    answer = "Not prime";
                    break;
                }
            }
            System.out.println(answer);
        }


    }
}
