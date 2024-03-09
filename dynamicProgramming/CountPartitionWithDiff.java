package dynamicProgramming;

import java.util.Arrays;

public class CountPartitionWithDiff {
    private static final int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        int n=4,diff=4;
        int [] a= new int[n];
        int totalSum=0;
        for (int x: a){
            totalSum+=x;
        }
        if(totalSum-diff<=0 || (totalSum-diff)%2!=0) {
            System.out.println(0);
        }
        else {
            System.out.println(findWays(a,(totalSum-diff)/2));
        }
    }
    public static int findWays(int[] num, int target) {
        int n= num.length;
        int[][] dp= new int[n][target+1];
        // Initialize DP table with -1 (unprocessed)
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solveRec(num,dp, n-1, target);
    }
    private static int solveRec(int[] a,int[][] dp, int index,int target){
        if(index == 0){
            if(target==0 && a[0]==0) return 2; // two ways.take a[0] or not take it
            if(target==0 || target == a[0]) return 1; //if target=0, only one way, to not take a[0],if target=a[0] only one way to take it
            return 0;
        }

        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notPick= solveRec(a,dp, index-1, target);
        int pick= 0;
        if(a[index]<=target){
            pick= solveRec(a, dp, index-1, target-a[index]);
        }
        return dp[index][target]= (pick+notPick)%MOD;
    }
}
