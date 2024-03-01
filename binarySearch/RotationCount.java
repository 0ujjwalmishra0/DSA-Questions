package binarySearch;

import static binarySearch.RotatedSortedArray.findPivot;

public class RotationCount {
    public static void main(String[] args) {
        int a[]= {10,12,1,2,3,4,5,7,9};
        int b[]={2,3,4,5,6};
        System.out.println(rotationCount(b));
    }
    static int rotationCount(int a[]){
        if(findPivot(a)==-1) return 0;
        return findPivot(a);
    }

}
