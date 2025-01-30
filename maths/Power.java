package maths;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(10,9));
    }

    private static int power(int n,int exp){
        if(exp==1) return n;

        if(exp%2==1){
            return n* power(n,exp-1);
        }else{
            return power(n*n,exp/2);
        }
    }
}
