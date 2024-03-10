package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

        int[] a= new int[]{1,2,2,1};
        int[] b= new int[]{2,2};
        System.out.println(Arrays.toString(intersection(a,b)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(nums1.length<nums2.length){
            for(int i=0;i<nums1.length;i++){
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        ans.add(nums1[i]);
                        i++;
                        j++;
                    }
                }
            }
        }
        else{
            for(int i=0;i<nums2.length;i++){
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] == nums1[j]) {
                        ans.add(nums2[i]);
                        i++;
                        j++;
                    }
                }
            }

        }
        int[] array = ans.stream().mapToInt(i -> i).toArray();
        return array;
    }
}
