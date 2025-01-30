package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    private static class Cell{
        int row;
        int col;
        int diff;
        Cell(int diff,int row,int col){
            this.diff= diff;
            this.row=row;
            this.col= col;
        }

    }
    public static void main(String[] args) {
        int[][] heights= new int[][]{{1, 2, 2}, {3, 8, 2}, {5 ,3 ,5}};
        System.out.println(MinimumEffort(heights));
    }
    static int MinimumEffort(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;
        int [][] distance = new int[n][m];
        for(int[] rows: distance){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        PriorityQueue<Cell> priorityQueue= new PriorityQueue<Cell>((x,y)-> x.diff-y.diff);
        priorityQueue.add(new Cell(0, 0, 0));
        distance[0][0]=0;
        int[] drow= new int[]{-1,0,0,1};
        int[] dcol= new int[]{0,-1,1,0};
        while(!priorityQueue.isEmpty()){
            Cell cell= priorityQueue.remove();
            if(cell.col==m-1 && cell.row==n-1){
                return cell.diff;
            }
            for (int i = 0; i < 4; i++) {
                int row= drow[i]+ cell.row;
                int col= dcol[i]+ cell.col;
                if(row>=0 && col>=0 && row<n && col<m) {
                    int diff = Math.abs(heights[row][col] - heights[cell.row][cell.col]);
                    int maxDiff = Math.max(diff, cell.diff);
                    //find min of dist and maxDiff
                    if (distance[row][col] > maxDiff) {
                        distance[row][col] = maxDiff;
                        priorityQueue.add(new Cell(maxDiff, row, col));
                    }
                }
            }
        }
        return 0;
    }
}
