package arrays;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 1, 10};
        System.out.println(getSecondSmallest(a));
    }
    private static int getSecondSmallest(int [] a){
        int smallest=a[0],secondSmallest=Integer.MAX_VALUE;
        for(int n: a){
            if(n<smallest){
                secondSmallest=smallest;
                smallest= n;
            }
            else if(n>smallest && n<secondSmallest){
                secondSmallest=n;
            }
        }
        return secondSmallest;
    }

}
