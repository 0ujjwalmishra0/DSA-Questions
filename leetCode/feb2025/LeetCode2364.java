package leetCode.feb2025;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2364 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(countBadPairs(a));
    }

    private static long countBadPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //compute nums[k]-k
            int c= nums[i]-i;
            map.put(c,map.getOrDefault(c,0)+1);
        }
        long countGoodPair=0;
        for(Integer i: map.values()){
            long pairs= (long) (i*(i-1))/2;
            countGoodPair+=pairs;
        }
        long totalPairs= ((long) nums.length *(nums.length-1))/2;
        return totalPairs- countGoodPair;

    }
}
