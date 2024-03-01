package recursion;

public class ReverseNumber {
    static int sum=0;

    public static void main(String[] args) {
//        System.out.println(reverse2(12345));
        System.out.println(countZeros(1,0));
    }
    private static void reverse(int n){
        //base case
        if(n==0) return;
        int r= n%10;
        sum=sum*10+ r;
        reverse(n/10);
    }

    private static int reverse2(int n){
        if(n<10) return n;
        int r=n%10;
        int digit = (int) (Math.log10(n)+1);
        n=n/10;
        return (int) (r*Math.pow(10,digit-1)+ reverse2(n));
    }

    private static int countZeros(int n,int count){
        if(n==0) return count;
        int r=n%10;
        if(r==0) return countZeros(n/10,++count);

        return countZeros(n/10,count);
    }
}
