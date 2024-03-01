package binarySearch;

import static binarySearch.PeakElement.findPeakMountainArray;

public class SearchInMountainArray {
    public static void main(String[] args) {
        int a [] = {1,12,13,14,15,16,4,3,2};
        int a2[]= {1,5,2};

        System.out.println(searchInMountainArray(a2,1));
    }
    private static int searchInMountainArray(int a[],int target){
        int peak = findPeakMountainArray(a);
        int leftIdx = binarySearch(a,0,peak,target);
        if(leftIdx>=0) return leftIdx;
        int rightIdx = binarySearchDecreasing(a,peak,a.length-1,target);
        if(rightIdx>=0) return rightIdx;
        return -1;
    }

    private static int binarySearch(int[] a,int start,int end, int target) {
        while (start <= end) {
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
    private static int binarySearchDecreasing(int[] a,int start,int end, int target) {
        while (start <= end) {
            int mid = start +(end - start) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                end= mid - 1;
            else
                start= mid + 1;
        }
        return -1;
    }
}
