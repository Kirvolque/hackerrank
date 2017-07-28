package com.epam;

import java.util.Scanner;
import java.util.Stack;

public class Queues {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        Boolean queueReversed = false;

        public void enqueue(T value) { // Push onto newest stack
            if (queueReversed) oldestToNewest();
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if (!queueReversed) {
                newestToOldest();
                return stackOldestOnTop.peek();
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if (!queueReversed) newestToOldest();
            return stackOldestOnTop.pop();

        }

        private void oldestToNewest() {
            queueReversed = false;
            while (!stackOldestOnTop.empty()) {
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }
        }

        private void newestToOldest() {
            queueReversed = true;
            while (!stackNewestOnTop.empty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
