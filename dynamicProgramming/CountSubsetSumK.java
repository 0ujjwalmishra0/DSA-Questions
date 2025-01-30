package dynamicProgramming;

import java.util.Arrays;

public class CountSubsetSumK {
    public static void main(String[] args) {
        int [] a= new int[]{1,2,3};
        int n=3,target=3;
        System.out.println(findWays(a,target));

    }
    private static int MOD= (int) (1e9+7);

    public static int findWays(int num[], int target) {
        int n= num.length;
        int[][] dp= new int[n][target+1];
        // Initialize DP table with -1 (unprocessed)
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int res=0;
        for(int i=num.length-1;i>=0;i--){
            res+= solveRec(num,dp, i, target);
        }
        return res;
    }
    private static int solveRec(int[] a,int[][] dp, int index,int target){
        if(target==0) return 1;
        if(index==0) {
            if(a[0]==target) return 1;
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
        return dp[index][target]= (pick%MOD+notPick%MOD);
    }

    private static int solveTabulation(int[] a,int index,int target){
        int [][] dp= new int[a.length][target+1];
        for(int i=0;i<a.length;i++){
            dp[i][0]=1;
        }
        if(index==0) {
            if(a[0]==target) {
                dp[0][a[0]]=1;
            }
            dp[0][a[0]]=0;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= target; j++) {
                int notPick= dp[index-1][j];
                int pick= 0;
                if(a[i]<=target){
                    pick= dp[i-1][j];
                }
                dp[i][j]= (int) (pick%MOD+notPick%MOD);
            }
        }
        return dp[a.length-1][target];
    }
    private static int solveTabulationSpaceOptimised(int[] a,int index,int target){
        int [][] dp= new int[a.length][target+1];
        int[] prev= new int[target+1];
        int[] curr= new int[target+1];
        prev[0]=curr[0]=1;

        if(index==0) {
            if(a[0]==target) {
                prev[a[0]]=1;
            }
            prev[a[0]]=0;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= target; j++) {
                int notPick= prev[j];
                int pick= 0;
                if(a[i]<=target){
                    pick= prev[j];
                }
                curr[j]= (int) (pick%MOD+notPick%MOD);
            }
            prev=curr;
        }
        return prev[target];
    }

}
