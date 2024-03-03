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
    private static int solveRecMemoization(int index, int[] heights,int[] dp) {
        if(index==0) return 0;
        if(dp[index]!=-1){
            return dp[index];
        }
        int left=  solveRecMemoization(index-1,heights,dp) + Math.abs(heights[index]-heights[index-1]);
        int right= Integer.MAX_VALUE;
        if(index>1) {
            right = solveRecMemoization(index - 2, heights,dp) + Math.abs(heights[index] - heights[index - 2]);
        }
        return dp[index]= Math.min(left,right);
    }

    private static int solveRecTabulation(int index, int[] heights) {
        int [] dp= new int[index+1];
        dp[0]=0;

        for(int i=1;i<index;i++){
            int left= dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i]= Math.min(left,right);
        }
        return dp[index-1];
    }

    private static int solveRecTabulationSpaceOptimised(int index, int[] heights) {

        int curr=0,prev=0,prev2=0;
        //for i=1,i=0 is the prev hence prev=dp[0]=0
        for(int i=1;i<index;i++){
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
