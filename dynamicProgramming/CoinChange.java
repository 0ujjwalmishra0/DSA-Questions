package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String args[]){
        int[] coins= new int[]{1,2};
//        System.out.println(coinChange(coins,8));
        fun();
    }

    public static int coinChange(int[] coins, int amount) {
//        return solveRec(coins,amount);

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        return solveRecMemoization(coins,dp,amount);
    }

    private static int solveRec(int [] coins,int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        for(int coin: coins){
            int count= solveRec(coins,amount-coin);
            if(count!=Integer.MAX_VALUE){
                minimum= Math.min(minimum,count+1);
            }
        }
        return minimum;
    }

    private static int solveRecMemoization(int [] coins,int[] dp,int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        if(dp[amount]!=1){
            return dp[amount];
        }
        for(int coin: coins){
            int count= solveRec(coins,amount-coin);
            if(count!=Integer.MAX_VALUE){
                minimum= Math.min(minimum,count+1);
            }
        }
        return minimum;
    }

    static void fun(){
        int i=0;
        int sum=0;
        while(i<100){
            sum=sum+i;
            sum=i+sum;
            i++;
        }
        System.out.println(sum);
    }
}
