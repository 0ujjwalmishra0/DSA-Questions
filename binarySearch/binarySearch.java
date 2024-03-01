package binarySearch;

public class binarySearch {
    public static void main(String[] args) {
        int[] a = { 2,3,5,9,14,15,16,18 };
//         System.out.println(binarySearch.binarySearch(a, 45););
//        System.out.println(ceiling(a,4));
//        System.out.println(floor(a,4));

        System.out.println(a[bsCeiling(a,15)]);
//        System.out.println(ceiling(a,15));
//        System.out.println(a[bsFloor(a,15)]);
//        System.out.println(floor(a,15));
    }

    public static int binarySearch(int[] a, int target) {
        int start = 0, end = a.length-1,mid=0;
        while (start < end) {
            mid = start +(end - start) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] > target)
                end= mid - 1;
            else
                start= mid + 1;
        }
        return -1;
    }
    private static int bsCeiling(int[] a, int target) {
        int start = 0, end = a.length-1;
        while (start <= end) {
           int mid = start +(end - start) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] > target)
                end= mid - 1;
            else
                start= mid + 1;
        }
        return start;
    }

    private static int bsFloor(int[] a, int target) {
        int start = 0, end = a.length-1;
        while (start <= end) {
            int mid = start +(end - start) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] > target)
                end= mid - 1;
            else
                start= mid + 1;
        }
        return end;
    }


    public static int mySqrt(int x) {
        if (x < 2) return x; // Handle 0 and 1 immediately
    
        int start = 1, end = x / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid; // Use long to avoid overflow
            if (square == x) return mid;
            if (square < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end; // Return end, as it will be the largest integer less than the square root of x
    }

    //find smallest no. greater than or equal to target
    private static int ceiling(int a[],int target){
        int start=0,end=a.length-1;
        while (start<end) {
            int mid= start + (end-start)/2;
            if(a[mid]==target) return a[mid];
            else if(a[mid]>target){
                //search in left
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return a[start];
    }

    // smallest no. equal or lower than target
    private static int floor(int a[],int target){
        int start=0,end=a.length-1;
        while (start<end){
            int mid= start+ (end-start)/2;
            if(a[mid]==target) return a[mid];
            else if(a[mid]> target){
                //look left excluding current idx
                end=mid-1;
            }
            else{
                //look right , including current idx
                start=mid;
            }
        }
        return a[start];
    }
    
}
