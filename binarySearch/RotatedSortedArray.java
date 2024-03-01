package binarySearch;

import static binarySearch.binarySearch.binarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int a[]= {10,12,1,2,3,4,5,7,9,10,10};
        System.out.println(pivotBinarySearch(a,12));
        System.out.println("pivot index: "+ findPivot(a));

        /*
        12,1,2,3,4,5,7,9,10
        10,12,1,2,3,4,5,7,9
        9,10,12,1,2,3,4,5,7
         */
    }

    private static int searchInRotatedArray(int a[],int target){
        int pivot = findPivot(a);
        if(pivot==-1){
            return binarySearch(a,target);
        }
        if(a[pivot]==target) return pivot;
        if(a[0]<target){
            return binarySearchRange(a,target,pivot+1,a.length-1);
        }
        else return binarySearchRange(a,target,0,pivot-1);
    }

    public static int findPivot(int[] a) {
        int start=0,end=a.length-1;
        if (a.length == 1 || a[0] < a[end]) {
            return -1; // Array is not rotated
        }
        while(start<=end){
            int mid= start+(end-start)/2;
            //check if mid is pivot
            if(mid<end && a[mid]>a[mid+1]){
                return mid+1;
            }
            //check if mid-1 is pivot
            if(mid>start && a[mid-1]>a[mid]){
                return mid-1;
            }
            // Decide which half to choose for the next step
            if(a[mid]>a[start]){
                //pivot in right
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    private static int pivotBinarySearch(int[] a,int target) {
        int start=0,end=a.length-1;
        while (start<=end){
            int mid= start+(end-start)/2;
            if(a[mid]==target) return mid;
            //find which side is properly sorted
            if(a[mid]>=a[start]){
                if(a[start]<=target && a[mid]> target){         //left side is sorted
                    end=mid-1;     //target in left side
                }
                else{
                    start=mid+1;   //target in right side
                }
            }else {                                             //right side is sorted
                if(a[mid]<=target && a[end]>target){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    private static int binarySearchRange(int a[],int target,int start,int end){
        while (start < end) {
            int mid = start +(end - start) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] > target)
                end= mid - 1;
            else
                start= mid + 1;
        }
        return -1;
    }
}
