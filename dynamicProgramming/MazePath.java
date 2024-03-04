package dynamicProgramming;

import java.util.Arrays;
//https://leetcode.com/problems/unique-paths/description/
public class MazePath {
    public static void main(String[] args) {
        int row=23,col=12;
        //if starting from (0,0) -> (n-1,m-1) going down,right
//        System.out.println(findPathRecDownToUP(row-1,col-1));
//        System.out.println(findPathRecUPtoDown(0,0,row,col));


        int [][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(findPathRecMemo(row-1,col-1,dp));

        System.out.println(findPathTabulation(row,col));
        System.out.println(findPathSpaceOptimized(row,col));
        System.out.println(findPathCombinatics(row,col));

    }

    private static int findPathRecDownToUP(int row,int col){
        if(row<0 || col<0) return 0;
        if(row==0 && col==0) return 1; //find one path to 0,0
        int up= findPathRecDownToUP(row-1,col);
        int left= findPathRecDownToUP(row,col-1);
        return up+left;
    }

    private static int findPathRecMemo(int row,int col,int [][] dp){
        if(row<0 || col<0) return 0;
        if(row==0 && col==0) return 1; //find one path to 0,0
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up= findPathRecMemo(row-1,col,dp);
        int left= findPathRecMemo(row,col-1,dp);
        return dp[row][col]= up+left;
    }

    private static int findPathTabulation(int row, int col) {
        int[][] dp = new int[row][col];

        // Initialize the first row and first column,only one way to reach
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp array
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of paths to the bottom-right cell
        return dp[row-1][col-1];
    }
    private static int findPathSpaceOptimized(int row, int col) {
        int[] prev = new int[col];
        // Initialize the first row
        Arrays.fill(prev,1);

        for (int i = 1; i < row; i++) {
            int [] curr= new int[col];
            curr[0] = 1;
            for (int j = 1; j < col; j++) {
                curr[j]= prev[j]+curr[j-1];
            }
            prev=curr; //prev becomes temp/current row
        }

        // Return the number of paths to the bottom-right cell
        return prev[col-1];
    }
    private static int findPathCombinatics(int row, int col) {
        //use C(n,k)= n!/(k! * (n-k)!)
//        C(n,k)= C(n,k−1)* (n-k+1)/k

        int totalWays= (row-1)+(col-1);
        int k = Math.min(row - 1, col - 1);
        long result=1;
        for (int i = 1; i <= k; i++) {
            result = result * (totalWays - i + 1) / i;
        }

        return (int) result;
    }



    private static int findPathRecUPtoDown(int row,int col,int maxRow,int maxCol){
        if(row>maxRow-1 || col>maxCol-1) return 0;
        if(row==maxRow-1 && col==maxCol-1) return 1;

        int down= findPathRecUPtoDown(row+1,col,maxRow,maxCol);
        int right= findPathRecUPtoDown(row,col+1,maxRow,maxCol);
        return down+right;
    }
}
