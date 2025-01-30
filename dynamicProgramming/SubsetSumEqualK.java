package dynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqualK {
    public static void main(String[] args) {
        int [] a= new int[]{4,3,2,1};
        int n=4,target=5;
        System.out.println(subsetSumToK(n,target,a));
        System.out.println(solveTabulation(a,target));
    }
    public static boolean subsetSumToK(int n, int target, int[] arr){
        int[][] dp= new int[n][target+1];
        // Initialize DP table with -1 (unprocessed)
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solveRec(arr,dp, n-1, target);
    }

    private static boolean solveRec(int[] a,int[][] dp, int index,int target){
        if(target==0) return true;
        if(index==0) return a[0]==target;

        if(dp[index][target]!=-1){
            return dp[index][target] != 0;
        }
        boolean notPick= solveRec(a,dp, index-1, target);
        boolean pick= false;
        if(a[index]<=target){
            pick= solveRec(a, dp, index-1, target-a[index]);
        }
        dp[index][target]= (pick || notPick)?1:0;
        return pick||notPick;

    }

    private static boolean solveTabulation(int[] a,int target){
        int size= a.length;
        boolean [][] dp= new boolean[size][target+1];
        for(int i=0;i<a.length;i++){
            dp[i][0]=true;
        }
        if(a[0]<=target) {
            dp[0][a[0]]=true;
        }

        for(int i=1;i<size;i++){
            for(int j=1;j<=target;j++){
                boolean notPick= dp[i-1][j];
                boolean pick= false;
                if(a[i]<=j){
                    pick= dp[i-1][j-a[i]];
                }
                dp[i][j]= pick||notPick;
            }
        }
        return dp[size-1][target];
    }
}
