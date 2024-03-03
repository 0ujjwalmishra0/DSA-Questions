package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-387/problems/distribute-elements-into-two-arrays-i/
public class DistributeElements {
    public static void main(String[] args) {
        int[] nums= new int[] {2,1,3};
        System.out.println(Arrays.toString(resultArray(nums)));
    }

    public static int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // First operation - append nums[0] to arr1 (1-indexed in question, 0-indexed in implementation)
        arr1.add(nums[0]);

        // Second operation - append nums[1] to arr2
        if (nums.length > 1) {
            arr2.add(nums[1]);
        }

        // From the 3rd operation onwards (2nd in 0-indexed)
        for (int i = 2; i < nums.length; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Concatenate arr1 and arr2 to form the result array
        arr1.addAll(arr2);
        return arr1.stream().mapToInt(i -> i).toArray();
    }
}
