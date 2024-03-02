package assignments.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int a[]= new int[]{1,1,1,1,1};
//        System.out.println(findTargetSumWays(a,3));


        int nums[]= new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0,0);
    }

    private static int solve(int [] a,int target,int index,int sum){
        if(index==a.length){
            if(sum==target)
                return 1;
            return 0;
        }


        int left= solve(a,target,index+1,sum+a[index]);


        int right= solve(a,target,index+1,sum-a[index]);
        return left+right;
    }
    private static int[] sortedSquares(int[] nums) {
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int n = nums[i];
            nums[i] = n * n;
        }
        Arrays.sort(nums);
        return nums;
    }
}
