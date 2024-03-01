package assignments.binarySearch;

public class ArrangingCoins {
    public static void main(String[] args) {
//        System.out.println(binarySearch(5));
//        System.out.println(binarySearch(8));
//        System.out.println(binarySearch(2));
        System.out.println(binarySearch(1804289383));
    }
        public static long binarySearch(int n) {
            //find in AP
            //S(n)=n/2[2a+(n-1)d]
            long start=1,end=n;
            while(start<=end){
                long mid= start+(end-start)/2;
                if(n==sum(mid)) return mid;
                if(sum(mid)>n){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            return end;
        }

        private static long sum(long n){
            return (n*(n+1))/2;
        }
}
