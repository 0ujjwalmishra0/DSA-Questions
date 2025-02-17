package leetCode.feb2025;

public class LeetCode1800 {

    public static void main(String[] args) {
        int[] a= new int[]{10,20,30,5,10,50};
        int[] a2= new int[]{100,10,1};
        int res= maxAscendingSum(a);
        System.out.println(res);
    }
    public static int maxAscendingSum(int[] nums) {
        int sum,maxSum=0;
        for(int i=0;i<nums.length-1;i++){
            int j=i;
            sum = nums[i];

            while(j<nums.length-1 && nums[j]<=nums[j+1]){
                sum+=nums[j+1];
                j++;
            }
            maxSum= Math.max(maxSum,sum);
        }
        return maxSum;
    }
}