package binarySearch;
//find peak element in mountain array- first half in asc, second in desc
public class PeakElement {
    public static void main(String[] args) {
        int a [] = {1,12,13,14,15,16,4,3,2};
        System.out.println(findPeakMountainArray(a));
        System.out.println(findPeakMountainArray2(a));
    }

    public static int findPeakMountainArray(int[] a){
        int start=0,end=a.length-1;
        while (start<end){
            int mid= start+(end-start)/2;
            if(a[mid]>a[mid+1]){
                //deceasing part of array,may be ans.
                //but also look in left
                end=mid;
            }
            else{
                //increasing part of array,look right
                start=mid+1;
            }
        }
        //start=end
        return start;
    }

    public static int findPeakMountainArray2(int [] a){
        int start=0,end=a.length-1;
        while (start<end){
            int mid= start+(end-start)/2;
            if(mid>0 && mid<a.length-1) {
                if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
                    return mid;
                } else if (a[mid] > a[mid - 1]) {
                    //increasing part of array,look right
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if(mid==0 && a[0]> a[1]) return 0;
            if(mid==a.length-1 && a[a.length-1]>a[a.length-2]) return a.length-1;
        }
        //start=end
        return start;
    }
}
