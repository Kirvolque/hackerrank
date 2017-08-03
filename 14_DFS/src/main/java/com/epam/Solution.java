package com.epam;


import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static int m;
    static int n;
    static int sizeOfRegion = 0;
    static int[][] matrix;

    public static int sizeOfRegion(int x, int y, HashSet<Point> points){
        if (x < 0|| x >= m || y < 0 || y >= n){
            return 0;
        }
        if (points.contains(new Point (x, y))){
            return 0;
        }
        if (matrix[x][y] != 0){
            points.add(new Point(x, y));

            sizeOfRegion(x, y - 1, points);
            sizeOfRegion(x, y + 1, points);
            sizeOfRegion(x - 1, y - 1, points);
            sizeOfRegion(x - 1, y, points);
            sizeOfRegion(x - 1, y + 1, points);
            sizeOfRegion(x + 1, y - 1, points);
            sizeOfRegion(x + 1, y, points);
            sizeOfRegion(x + 1, y + 1, points);
        }

        return points.size();
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }


    public static int getBiggestRegion() {
        int size;
        for (int xc = 0; xc < m;  xc++){

            for (int yc = 0; yc < n; yc++){
                size = sizeOfRegion(xc, yc, new HashSet<Point>());
                if (size > sizeOfRegion) sizeOfRegion = size;

            }

        }
        return sizeOfRegion;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        matrix = grid;
        System.out.println(getBiggestRegion());
    }
}
