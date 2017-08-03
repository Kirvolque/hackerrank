package com.epam;


import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static int m;
    static int n;
    static int sizeOfRegion = 0;
    static int[][] matrix;
    static HashSet<Point> points;


    public static void sizeOfRegion(int x, int y){
        if (x >= 0 && x < m && y >= 0 && y < n
                && matrix[y][x] != 0
                &&!points.contains(new Point (x, y))){

            points.add(new Point(x, y));

            sizeOfRegion(x, y - 1);
            sizeOfRegion(x, y + 1);

            sizeOfRegion(x - 1, y - 1);
            sizeOfRegion(x - 1, y);
            sizeOfRegion(x - 1, y + 1);

            sizeOfRegion(x + 1, y - 1);
            sizeOfRegion(x + 1, y);
            sizeOfRegion(x + 1, y + 1);
        }

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
        for (int yc = 0; yc < n;  yc++){

            for (int xc = 0; xc < m; xc++){
                if (matrix[yc][xc] != 0){
                    points = new HashSet<Point>();
                    sizeOfRegion(xc, yc);
                    size = points.size();
                    if (size > sizeOfRegion) sizeOfRegion = size;
                }
            }
        }

        return sizeOfRegion;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
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
