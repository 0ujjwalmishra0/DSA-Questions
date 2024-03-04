package dynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths-ii/description/
public class MazepathObstacles {
    public static void main(String[] args) {
        int[][] obstacle= new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(findPathTabulation(obstacle));
    }

    private static int findPathRecMemo(int row,int col,int[][] obstacle,int [][] dp){

        if(row<0 || col<0 || obstacle[row][col]==1) return 0;
        if(row==0 && col==0) return 1; //find one path to 0,0
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up= findPathRecMemo(row-1,col,obstacle,dp);
        int left= findPathRecMemo(row,col-1,obstacle,dp);
        return dp[row][col]= up+left;
    }

    private static int findPathTabulation(int[][] obstacleGrid){

        int row= obstacleGrid.length;
        int col= obstacleGrid[0].length;
        int [][] dp= new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }

        // Fill the dp array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]= 0;
                } else if(i==0 && j==0){
                    dp[i][j]=1;
                }else {
                    int up=0,left=0;
                    if(i>0) up=   dp[i - 1][j];
                    if(j>0) left= dp[i][j - 1];
                    dp[i][j]= up+left;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
