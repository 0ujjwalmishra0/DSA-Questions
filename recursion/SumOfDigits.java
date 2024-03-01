package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n= 12345;
//        System.out.println(sum(n));
    }
    private static int sumDigits(int n){
        //base case
        if(n<10) return n;
        int r= n%10;
        n=n/10;
        return r+sumDigits(n);
    }


}
