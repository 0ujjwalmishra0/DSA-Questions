package dynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int a[]= new int[]{1,100,1,1,1,100,1,1,100,1};
        int ans= minCostClimbingStairs(a);
        System.out.println(ans);
        System.out.println(minCostClimbingStairsMemoization(a));
        System.out.println(minCostClimbingStairsTabulationSpaceOptimised(a));
    }
    public static int minCostClimbingStairs(int[] a) {
        int ans1= solveStairs(a,0,0);
        int ans2= solveStairs(a,0,1);
        return (Math.min(ans2,ans1));
    }

    private static int solveStairs(int a[],int sum,int index){
        if(index>=a.length){
            return sum;
        }
        int step1= solveStairs(a,sum+a[index],index+1);
        int step2= solveStairs(a,sum+a[index],index+2);
        return Math.min(step1,step2);
    }

    private static int solveStairs(int a[],int index){
        if(index>=a.length){
            return 0;
        }
        int step1= a[index]+ solveStairs(a,index+1);
        int step2= a[index]+ solveStairs(a,index+2);
        return Math.min(step1,step2);
    }
    public static int minCostClimbingStairsMemoization(int[] cost) {
        // Initialize a memoization array with -1 to indicate uncomputed values
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        int ans1 = solveStairs(cost, 0, memo);
        int ans2 = solveStairs(cost, 1, memo);

        return Math.min(ans1, ans2);
    }

    private static int solveStairs(int[] cost, int index, int[] memo) {
        // Base case: if the index is beyond the last step, no cost is needed
        if (index >= cost.length) {
            return 0;
        }

        // Check if this state has already been computed
        if (memo[index] != -1) {
            return memo[index];
        }

        // Recursive calls: add the cost of the current step to the minimum cost of the next steps
        int step1 = cost[index] + solveStairs(cost, index + 1, memo);
        int step2 = cost[index] + solveStairs(cost, index + 2, memo);

        // Store the result in the memoization array before returning
        memo[index] = Math.min(step1, step2);

        return memo[index];
    }

    public static int minCostClimbingStairsTabulation(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // Create DP table to store the minimum cost to reach each step

        // Base cases for tabulation
        dp[n] = 0; // No cost to reach the top from the top
        dp[n - 1] = cost[n - 1]; // Cost to reach the top from the last step is the cost of the last step itself

        // Fill the dp table from the end to the beginning
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        // The result will be the minimum of the first two entries, as you can start from either step 0 or step 1
        return Math.min(dp[0], dp[1]);
    }
    public static int minCostClimbingStairsTabulationSpaceOptimised(int[] cost) {
        int n = cost.length;
        // Base cases for tabulation
        int lastStep = 0; // No cost to reach the top from the top
        int prevStep = cost[n - 1]; // Cost to reach the top from the last step is the cost of the last step itself

        for (int i = n - 2; i >= 0; i--) {
            int curr= cost[i]+ Math.min(lastStep,prevStep);
            lastStep=prevStep;
            prevStep=curr;
//            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(lastStep, prevStep);
    }


}
