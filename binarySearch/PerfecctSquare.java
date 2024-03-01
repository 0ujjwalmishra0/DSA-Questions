package binarySearch;

public class PerfecctSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare (int num){
        if(num ==0 || num==1) return true;
        long res = binarySearch(num);
        if (res >= 0) return true;
        return false;
    }

    public static long binarySearch(int num){
        long start=0,end=num/2;
        while(start<=end){
            long mid= start+(end-start)/2;
            Long square = (long) (mid*mid);
            if(square==num) return mid;
            if(square>num){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
