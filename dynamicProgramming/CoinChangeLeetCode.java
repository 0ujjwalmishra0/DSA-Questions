package dynamicProgramming;

import java.util.Arrays;

public class CoinChangeLeetCode {
    public static void main(String[] args) {
        int[] a= new int[]{1,2,5};
        int amount=11;

        System.out.println(coinChange(a,amount));
        System.out.println(solveTabulation(a,amount));
        System.out.println(solveTabulationSpaceOptimised(a,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        int ans=  solveRec(coins,dp,coins.length-1,amount);
        if(ans>=1e9){
            return -1;
        }
        return ans;
    }

    private static int solveRec(int[] coins,int[][] dp,int index,int amount){
        if(index==0) {
            if(amount%coins[index]==0){
                return amount/coins[index];
            }else{
                return (int) 1e9;
            }
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        int take=Integer.MAX_VALUE;
        int notTake = solveRec(coins,dp, index - 1, amount);
        if(coins[index]<=amount) {
            take = 1+solveRec(coins, dp, index, amount - coins[index]);
        }

        return dp[index][amount]= Math.min(take,notTake);
    }

    private static int solveTabulation(int[] coins,int amount){
        int[][] dp= new int[coins.length][amount+1];
        for (int t = 0; t <= amount; t++) {
            if(t%coins[0]==0){
                dp[0][t]= t/coins[0];
            }else{
                dp[0][t]= Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j) {
                    take = 1+dp[i][j-coins[i]];
                }
                dp[i][j]= Math.min(take,notTake);
            }
        }
        return dp[coins.length-1][amount];
    }



    private static int solveTabulationSpaceOptimised(int[] coins,int amount){

        int[] prev= new int[amount+1];
        int[] curr= new int[amount+1];
        for (int t = 0; t <= amount; t++) {
            if(t%coins[0]==0){
                prev[t]= t/coins[0];
            }else{
                prev[t]= Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = prev[j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j) {
                    take = 1+curr[j-coins[i]];
                }
                curr[j]= Math.min(take,notTake);
            }
            prev=curr;
        }
        return prev[amount];
    }
}
