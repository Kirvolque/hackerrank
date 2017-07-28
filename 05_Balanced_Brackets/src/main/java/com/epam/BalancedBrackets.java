package com.epam;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        char bracket;
        for (int i = 0; i < expression.length(); i++){
            bracket = expression.charAt(i);
            if (isClosingBracket(bracket)){
                if (stack.isEmpty()) return false;
                else if (secondBracket(stack.pop()) != bracket) return false;
            } else stack.push(bracket);
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static boolean isClosingBracket (char bracket){
        if (bracket == ')' || bracket == '}' || bracket == ']'){
            return true;
        }
        return false;
    }

    public static char secondBracket(char firstBracket) {
        if (firstBracket == '{') return '}';
        else if (firstBracket == '[') return ']';
        else if (firstBracket == '(') return ')';
        return 'Z';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}