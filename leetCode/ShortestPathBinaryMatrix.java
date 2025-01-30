package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
        public static class Cell {
            int row;
            int col;
            int dist;

            public Cell(int dist, int row, int col) {
                this.dist = dist;
                this.row = row;
                this.col = col;
            }
        }

    public static void main(String[] args) {
        int[][] grid= new int[][]{{1,0,0},{1,1,0},{1,1,0}};

        System.out.println(shortestPathBinaryMatrix(grid));
    }
        public static int shortestPathBinaryMatrix(int[][] grid) {
            return shortestPath(grid, new int[] { 0, 0 }, new int[] { grid.length - 1, grid.length - 1 });
        }

        static int shortestPath(int[][] grid, int[] source, int[] destination) {
            if(grid[source[0]][source[1]]==1) return -1;
            if (source[0] == destination[0] && source[1] == destination[1])
                return 1;
            Queue<Cell> queue = new LinkedList<>();
            int[][] distance = new int[grid.length][grid[0].length];
            for (int[] rows : distance) {
                Arrays.fill(rows, Integer.MAX_VALUE);
            }
            queue.add(new Cell(1, source[0], source[1]));
            distance[source[0]][source[1]] = 1;
            int[] drow = { -1, 1, 0, 0,-1,-1,1,1 };
            int[] dcol = { 0, 0, -1, 1,-1,1,-1,1 };
            while (!queue.isEmpty()) {
                Cell cell = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int row = drow[i] + cell.row;
                    int col = dcol[i] + cell.col;

                    if (row >= 0 && col >= 0 && row < grid.length &&
                            col < grid[0].length && grid[row][col] == 0) {
                        if (distance[row][col] > 1 + cell.dist) {
                            distance[row][col] = 1 + cell.dist;
                            queue.add(new Cell(cell.dist + 1, row, col));
                            if (row == destination[0] && col == destination[1]) {
                                return 1 + cell.dist;
                            }
                        }
                    }
                }
            }

            return -1;
        }
}
