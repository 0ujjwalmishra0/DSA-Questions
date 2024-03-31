package maths;

public class GCD {
    public static void main(String[] args) {
        System.out.println(calcGCD(20,11));
        System.out.println(calcGCD(11,97));
        System.out.println(gcdRec(20,40));
    }

    public static int calcGCD(int n, int m){
        int gcd=0;
        for (int i = 1; i <= Math.min(n,m); i++) {
            if(n%i==0 && m%i==0){
                gcd=Math.max(gcd,i);
            }
        }
        return gcd;
    }

    private static int gcdRec(int a,int b){
        if(a==0) return b;
        if(b==0) return a;
        int max= Math.max(a,b);
        int min= Math.min(a,b);
        return gcdRec(max%min,min);
    }
}
