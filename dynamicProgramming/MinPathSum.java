package dynamicProgramming;

//https://leetcode.com/problems/minimum-path-sum/description/
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid= new int[][]{{1,2,3},{4,5,6}};
//                new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int row= grid.length;
        int col= grid[0].length;
        System.out.println(minPathSumRec(grid,row-1,col-1));
    }

//    private static int minPathSumRec(int[][] grid,int row,int col){
//
//        if(row<0 || col<0) return Integer.MAX_VALUE;
//        if(row==0 && col==0) return grid[row][col];
//        int up=grid[row][col]+minPathSumRec(grid,row-1,col);
//        int left= grid[row][col]+minPathSumRec(grid,row,col-1);
//        return Math.min(up,left);
//    }

    private static int minPathSumRec(int[][] grid, int row, int col) {
        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if (row == 0 && col == 0) return grid[row][col];

        int up = minPathSumRec(grid, row - 1, col);
        int left = minPathSumRec(grid, row, col - 1);
        return grid[row][col] + Math.min(up, left);
    }

}
