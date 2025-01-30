package dynamicProgramming;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] weight= new int[]{3,2,5};
        int[] value = new int[]{30,40,60};
        int W= 6;
        System.out.println(knapsack(weight,value,weight.length,W));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solveRec(weight,value,dp,weight.length-1,maxWeight);
    }

    private static int solveRec(int[] weight,int[] value,int[][] dp, int index, int maxWeight){
        if(index==0) {
            if (weight[0] <= maxWeight) {
                return value[0];
            }else{
               return 0;
            }
        }
        int left=0;
        if(dp[index][maxWeight]!=-1){
            return dp[index][maxWeight];
        }
        if(weight[index]<=maxWeight) {
            left = value[index]+ solveRec(weight, value, dp,index - 1, maxWeight - weight[index]);
        }
        int right= solveRec(weight,value,dp,index-1,maxWeight);

        return dp[index][maxWeight]= Math.max(left,right);
    }
}
