package dynamicProgramming;

import java.util.Arrays;
//https://leetcode.com/problems/fibonacci-number/description/
public class Fibonnaci {
    public static void main(String[] args) {
        Long start= System.currentTimeMillis();
        int n=15;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n,dp));
        System.out.println(fibTabulation(n));
        System.out.println(fibTabulationSpaceOptimised(n));
        Long end = System.currentTimeMillis();
        System.out.println("time taken: "+ (end-start));
    }

    private static int fib(int n,int [] dp){
        if(n==0 || n==1) return n;

        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = fib(n-1,dp)+ fib(n-2,dp);
        return dp[n];
    }

    private static int fibTabulation(int n){
        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n ; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int fibTabulationSpaceOptimised(int n){
        int prev2=0;
        int prev1=1;
        int ans=0;
        if(n<2) return n;
        for (int i = 2; i <= n ; i++) {
            ans= prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return prev1;
    }
}
