package leetCode;

public class MinCommonValue {
    public static void main(String[] args) {
        int[] a= new int[]{1,2,3,6};
        int[] b= new int[]{1,3,14,15};
        System.out.println(getCommon(a,b));
    }
    public int getCommon2pointer(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int length1=nums1.length;
        int length2= nums2.length;
        // For faster solution
        if (nums1[length1-1] < nums2[0] || nums2[length2-1] < nums1[0])
            return -1;

        // Two pointer approach
        while (i<length1 && j<length2) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        } return -1;
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int size1=nums1.length,size2=nums2.length;
        if(size1<size2){
          //iterate through nums1 and find min in nums2
          for(int i=0;i<size1;i++){
              int min= nums1[i];
              int searchIndex= binarySearch(nums2,min);
              if(searchIndex!=-1) {
                  return nums2[searchIndex];
              }
          }
        }
        else{
            //iterate through nums2 and find min in nums1
            for(int i=0;i<size2;i++){
                int min= nums2[i];
                int searchIndex= binarySearch(nums1,min);
                if(searchIndex!=-1) {
                    return nums1[searchIndex];
                }
            }
        }
        return -1;
    }


    private static int binarySearch(int [] a,int target){
        int start=0,end=a.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(a[mid]==target) return mid;
            if(a[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
