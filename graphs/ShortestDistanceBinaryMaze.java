package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {
    public static class Cell{
        int row;
        int col;
        int dist;
        public Cell(int dist,int row,int col){
            this.dist= dist;
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String[] args) {
        int[][] grid= new int[][]{{1,1, 1, 1}, {1 ,1 ,0 ,1}, {1, 1 ,1 ,1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int [] source= new int[]{0,1};
        int [] dest= new int[]{2,2};

        System.out.println(shortestPath(grid,source,dest));
    }
    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        Queue<Cell> queue= new LinkedList<>();
        int[][] distance = new int[grid.length][grid[0].length];
        for (int[] rows : distance) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        queue.add(new Cell(0, source[0], source[1]));
        distance[source[0]][source[1]]=0;
        int[] drow= {-1,1,0,0};
        int [] dcol= {0,0,-1,1};
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row= drow[i]+cell.row;
                int col= dcol[i]+cell.col;

                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1
                        && cell.dist + 1 < distance[row][col]){
                    if(distance[row][col]> 1+cell.dist){
                        distance[row][col]= 1+cell.dist;
                        queue.add(new Cell(cell.dist+1,row,col));
                        if(row==destination[0] && col==destination[1]){
                            return 1+cell.dist;
                        }
                    }
                }
            }
        }


        return -1;
    }
}
