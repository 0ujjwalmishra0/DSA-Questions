package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public static void main(String[] args) {
        int a[]= new int[]{2,7,9,3,1,12,17,19,13,11,22,27,29,23,21,9,8};
        int b[]= new int[]{1,2};
//        System.out.println(maxSum(a,new ArrayList<>(),0));
        System.out.println(rob(b));

    }

    public static int rob(int[] nums) {
//        return maxSum(nums,new ArrayList<>(),0);
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,-1);
//        return maxSumMemoization(nums,new ArrayList<>(),0,dp);
        int[][] dp = new int[nums.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxSumMemoization2(nums, 0, false, dp);
    }

    private static int maxSum(int nums[], ArrayList<Integer> processed, int index){
        if (index==nums.length) {
            return 0;
        }
        int leftSum=0,rightSum=0;
        if(index>0) {
            if(processed.getLast()==nums[index-1]){
                leftSum = maxSum(nums, processed, index + 1);
            }
            else {
                processed.add(nums[index]);
                leftSum = nums[index] + maxSum(nums, processed, index + 1);
            }
            rightSum = maxSum(nums, processed, index + 1);
        }
            else {
                processed.add(nums[index]);
                leftSum = nums[index] + maxSum(nums, processed, index + 1);
            }
            rightSum = maxSum(nums, processed, index + 1);
        return Math.max(leftSum,rightSum);

    }
    private static int maxSumMemoization(int nums[], ArrayList<Integer> processed, int index,int[] dp){
        if (index==nums.length) {
            return 0;
        }
        int leftSum=0,rightSum=0;
        if(dp[index]!=-1) return dp[index];

        if(index>0) {
            if(processed.getLast()==nums[index-1]){
                leftSum = maxSumMemoization(nums, processed, index + 1,dp);
                rightSum = maxSumMemoization(nums, processed, index + 1,dp);
            }
            else {
                processed.add(nums[index]);
                leftSum = nums[index] + maxSumMemoization(nums, processed, index + 1,dp);
                rightSum = maxSumMemoization(nums, processed, index + 1,dp);
            }
        }
        else {
            processed.add(nums[index]);
            leftSum = nums[index] + maxSumMemoization(nums, processed, index + 1,dp);
            rightSum = maxSumMemoization(nums, processed, index + 1,dp);
        }

        return dp[index] = Math.max(leftSum,rightSum);

    }


    private static int maxSumMemoization2(int[] nums, int index, boolean prevIncluded, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        int dpIndex = prevIncluded ? 1 : 0;
        if (dp[index][dpIndex] != -1) {
            return dp[index][dpIndex];
        }

        int take = 0;
        if (!prevIncluded) {
            take = nums[index] + maxSumMemoization2(nums, index + 1, true, dp);
        }
        int skip = maxSumMemoization2(nums, index + 1, false, dp);

        dp[index][dpIndex] = Math.max(take, skip);
        return dp[index][dpIndex];
    }

    private static int maxSumBacktrack(int nums[], ArrayList<Integer> processed, int index){
        if (index == nums.length) {
            return 0;
        }

        int leftSum = 0, rightSum = 0;

        // Check if the current element can be added to the processed list
        if (index == 0 || (index > 0 && processed.getLast() != nums[index - 1])) {
            processed.add(nums[index]);
            leftSum = nums[index] + maxSumBacktrack(nums, processed, index + 1);
            processed.remove(processed.size() - 1); // Backtrack to remove the added element
        } else {
            leftSum = maxSumBacktrack(nums, processed, index + 1);
        }

        // Option to skip the current element
        rightSum = maxSumBacktrack(nums, processed, index + 1);

        return Math.max(leftSum, rightSum);
    }
}
