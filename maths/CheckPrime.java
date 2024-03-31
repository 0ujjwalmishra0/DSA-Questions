package maths;

public class CheckPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(1));
    }
    public static boolean isPrime(int num) {
        int count=0;
        if(num==1) return false;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                count++;
            }
            if(num/i!=i){
                count++;
            }
            if(count>2){
                return false;
            }
        }
        return true;
    }
}
