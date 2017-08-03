package com.epam;


import java.util.*;


public class Solution {

    public static class Graph {

        List<List<Integer>> neighbours;

        int size;

        public Graph(int size) {
            neighbours = new ArrayList<>();
            this.size = size;

            while (size-- > 0)
                neighbours.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            neighbours.get(first).add(second);
            neighbours.get(second).add(first);

        }

        public int[] shortestReach(int startingNode) {
            int [] distances = new int [size];

            Arrays.fill(distances, -1);

            Queue<Integer> que = new LinkedList<>();

            que.add(startingNode);
            distances[startingNode] = 0;

            HashSet<Integer> visited = new HashSet<>();

            visited.add(startingNode);

            while (!que.isEmpty()) {
                Integer currentNode = que.poll();
                for (int node : neighbours.get(currentNode)){
                    if (!visited.contains(node)){
                        que.add(node);
                        visited.contains(node);
                        distances[node] = distances[currentNode] + 6;
                    }
                }

            }
            return distances;

        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }




}
