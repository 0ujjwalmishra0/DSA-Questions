package assignments.array;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {

    }
    public boolean isPossibleToSplit(int[] nums) {
        Arrays.sort(nums);
        int count=1;
        int i=1;
        while(i<nums.length){
            if(nums[i-1]==nums[i]){
                count++;
                i++;
            } else{
                count=1;
                i++;
                continue;
            }

            if(count>2){
                return false;
            }

        }
        return true;
    }
}
