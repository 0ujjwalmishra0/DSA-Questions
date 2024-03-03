package dynamicProgramming;

import java.util.Arrays;

//https://atcoder.jp/contests/dp/tasks/dp_b
public class FrogJumpKDistance {
    public static void main(String[] args) {
        int [] a= new int[]{10,30,40,50,20};
        int [] b= new int[]{10,20,10};
        int n=3,k=1;
        int [] dp= new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(solveRecMemoization(n-1,k,b,dp));
        System.out.println(solveRecTabulation(n,k,b));
    }

    private static int solveRecMemoization(int index,int k, int[] heights,int[] dp) {
        if(index==0) return 0;
        if(dp[index]!=-1){
            return dp[index];
        }
        int min= Integer.MAX_VALUE;
        for (int ksteps = 1; ksteps <= k; ksteps++) {
            if(index-ksteps>=0) {
                min = Math.min(min, solveRecMemoization(index - ksteps, k, heights, dp) + Math.abs(heights[index] - heights[index - ksteps]));
            }
        }
        return dp[index]= min;
    }

    private static int solveRecTabulation(int n,int k, int[] heights) {
        int[] dp = new int [n+1];
        dp[0]=0;

        for (int i = 1; i < n; i++) {
            int min= Integer.MAX_VALUE;
            for (int ksteps = 1; ksteps <= k; ksteps++) {
                if (i - ksteps >= 0) {
                    min = Math.min(min, dp[i - ksteps] + Math.abs(heights[i] - heights[i - ksteps]));
                }
            }
            dp[i]= min;
        }
        return dp[n-1];
    }
}
