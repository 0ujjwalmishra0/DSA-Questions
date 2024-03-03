package dynamicProgramming;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/frog-jump_3621012
public class FrogJump {
    public static void main(String args[]){
        int a[]= new int[]{10,20,30,10};
        System.out.println(frogJump(4,a));
        System.out.println(solveRecTabulation(4,a));
        System.out.println(solveRecTabulationSpaceOptimised(4,a));
    }

    public static int frogJump(int n, int heights[]) {
//        return solveRec(n-1,heights);
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return solveRecMemoization(n-1,heights,dp);
        return solveRecTabulationSpaceOptimised(n,heights);
    }

    private static int solveRec(int n, int[] heights) {
        if(n==0) return 0;

        int left= solveRec(n-1,heights)+Math.abs(heights[n]-heights[n-1]);
        int right= Integer.MAX_VALUE;
        if(n>1) {
            right = solveRec(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return Math.min(left,right);
    }
    private static int solveRecMemoization(int n, int[] heights,int[] dp) {
        if(n==0) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int left=  solveRecMemoization(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);
        int right= Integer.MAX_VALUE;
        if(n>1) {
            right = solveRecMemoization(n - 2, heights,dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n]= Math.min(left,right);
    }

    private static int solveRecTabulation(int n, int[] heights) {
        int [] dp= new int[n+1];
        dp[0]=0;

        for(int i=1;i<n;i++){
            int left= dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i]= Math.min(left,right);
        }
        return dp[n-1];
    }

    private static int solveRecTabulationSpaceOptimised(int n, int[] heights) {

        int curr=0,prev=0,prev2=0;
        //for i=1,i=0 is the prev hence prev=dp[0]=0
        for(int i=1;i<n;i++){
            int left= prev+Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            curr= Math.min(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
