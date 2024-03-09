package leetCode;

import java.util.Arrays;

public class CountElementWithMaxFreq {
    public static void main(String[] args) {
        int a[]= new int[]{1,1,1,1};
        System.out.println(maxFrequencyElements(a));
    }
    private static int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);
        int max=1,sameFreq=1;
        for(int i=1;i<nums.length;i++){
            int freq=1;
            while(i<nums.length && nums[i]==nums[i-1]){
                freq++;
                i++;
            }
            if(freq>max){
                max=freq;
                sameFreq=1;
            }else if(freq==max){
                sameFreq++;
                max=freq;
            }
        }
        return sameFreq*max;
    }
}
